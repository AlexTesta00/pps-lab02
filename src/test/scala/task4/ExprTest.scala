package task4

import org.junit.*
import org.junit.Assert.*

class ExprTest:

  @Test def correctEvaluateLiteralShouldReturnItsValue(): Unit =
    val expr = Expr.Literal(5)
    assertEquals(5, Expr.evaluate(expr))

  @Test def correctEvaluateAddShouldReturnSumOfSubExpressions(): Unit =
    val expr = Expr.Add(Expr.Literal(2), Expr.Literal(3))
    assertEquals(5, Expr.evaluate(expr))

  @Test def correctEvaluateMultiplyShouldReturnProductOfSubExpressions(): Unit =
    val expr = Expr.Multiply(Expr.Literal(4), Expr.Literal(5))
    assertEquals(20, Expr.evaluate(expr))

  @Test def evaluateNestedExpressionShouldRespectExpressionTreeStructure(): Unit =
    val expression =
      Expr.Add(
        Expr.Literal(2),
        Expr.Multiply(Expr.Literal(3), Expr.Literal(4))
      )
    assertEquals(14, Expr.evaluate(expression))

  @Test def evaluateDeeplyNestedExpressionShouldComputeCorrectResult(): Unit =
    val expression =
      Expr.Multiply(
        Expr.Add(Expr.Literal(1), Expr.Literal(2)),
        Expr.Add(Expr.Literal(3), Expr.Literal(4))
      )
    assertEquals(21, Expr.evaluate(expression))

  @Test def showLiteralShouldReturnItsNumericValueAsString(): Unit =
    val literal = Expr.Literal(5)
    assertEquals("5", Expr.show(literal))

  @Test def showAddShouldWrapOperandsAndOperatorInParentheses(): Unit =
    val addition = Expr.Add(Expr.Literal(1), Expr.Literal(2))
    assertEquals("(1 + 2)", Expr.show(addition))

  @Test def showMultiplyShouldWrapOperandsAndOperatorInParentheses(): Unit =
    val multiplication = Expr.Multiply(Expr.Literal(3), Expr.Literal(4))
    assertEquals("(3 * 4)", Expr.show(multiplication))

  @Test def showNestedExpressionShouldPreserveTreeStructureInStringForm(): Unit =
    val expression =
      Expr.Add(
        Expr.Literal(2),
        Expr.Multiply(Expr.Literal(3), Expr.Literal(4))
      )
    assertEquals("(2 + (3 * 4))", Expr.show(expression))

  @Test def showDeeplyNestedExpressionShouldRenderAllParenthesesExplicitly(): Unit =
    val expression =
      Expr.Multiply(
        Expr.Add(Expr.Literal(1), Expr.Literal(2)),
        Expr.Add(Expr.Literal(3), Expr.Literal(4))
      )
    assertEquals("((1 + 2) * (3 + 4))", Expr.show(expression))