package task3

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
def reverseNumber(n: Int): Int =
  @tailrec
  def _reverseNumber(n: Int, acc: Int): Int = n match
    case 0 => acc
    case _ => _reverseNumber(n / 10, acc * 10 + n % 10)
  _reverseNumber(n, 0)

@main def testReverseNumber(): Unit = {
  println((reverseNumber(12345)))
}

//Exercise 9