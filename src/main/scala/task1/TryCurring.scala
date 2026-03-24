package task1

import scala.util.Try

def mult(x: Double, y: Double): Double = x * y

def curriedMult(x: Double)(y: Double): Double = x * y

def divide(x: Double, y: Double): Double = y match {
  case n if y == 0 => throw new IllegalArgumentException("Cannot divide by zero")
  case _ => x / y
}

def curriedDivide(x: Double)(y: Double): Double = y match {
  case n if y == 0 => throw new IllegalArgumentException("Cannot divide by zero")
  case _ => x / y
}

@main def runTryCurrying(): Unit = {

  //Test function not curried
  println(mult(10, 2)) // 20

  //Test function curried
  println(curriedMult(10)(2)) // 20

  //Test partially applied function
  val forTwo: Double => Double = curriedMult(2)
  println(forTwo(10)) // 20

  //Test curried function as a function value
  val curriedMultAsFunction: Double => Double => Double = x => y => x * y
  println(curriedMultAsFunction(10)(2)) // 20

  //Test divide not curried
  println(divide(10, 2)) // 5

  //Test divide curried
  println(curriedDivide(10)(2)) // 5

  //Test divide by zero not curried Java-like exception handling
  try {
    println(divide(10, 0))
  } catch {
    case e: IllegalArgumentException => println(e.getMessage) // Cannot divide by zero
  }

  //Test divide by zero curried Scala-like exception handling
  val res = curriedDivide(10)(0) match {
    case n => n
    case e: IllegalArgumentException => e.getMessage
  }

  println(res) // Cannot divide by zero

  //Test divide by Try in Scala utils
  println(Try[Double](curriedDivide(10)(0)))
}