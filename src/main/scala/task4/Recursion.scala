package task4

import scala.annotation.tailrec

//Exercise 7
def power(base: Double, exponent: Int): Double =
  @tailrec
  def _power(base: Double, exponent: Int, acc: Double): Double = exponent match
    case 0 => acc
    case e if e > 0 => _power(base, exponent - 1, acc * base)
    case e if e < 0 => throw IllegalStateException("Exponent must be non-negative")
  _power(base, exponent, 1)

@main def testPower(): Unit = {
  println((power(2, 3), power(5, 2)))
}

//Exercise 8

//Exercise 9