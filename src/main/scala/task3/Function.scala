package task3

//Exercise 3.a

//Val assigned to function literal (lambda)
val sign: (Int) => String = {
  case x if x >= 0 => "positive"
  case x if x < 0 => "negative"
}

//Method Syntax
def signMethod(x: Int): String = x match {
  case x if x >= 0 => "positive"
  case x if x < 0 => "negative"
}

//Exercise 3.b

//Neg in val syntax
val neg: ((String) => Boolean) => (String) => Boolean = {
  (f: (String) => Boolean) => (x: String) => !f(x)
}

//Neg in method syntax
def negMethod[E](f: (E) => Boolean): (E) => Boolean = {
  (x: E) => !f(x)
}

//Exercise 4

//Preidcate in val syntax and currying
val p1: (Int) => (Int) => (Int) => Boolean = (x: Int) => (y: Int) => (z: Int) => x < y && y < z

//Predicate in val syntax not curried
val p2: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x < y && y < z

//Predicate in def syntax and currying
def p3(x: Int)(y: Int)(z: Int): Boolean = x < y && y < z

//Predicate in def syntax not curried
def p4(x: Int, y: Int, z: Int): Boolean = x < y && y < z

//Exercise 5

//Function compose
def compose[A,B,C](f: (B) => C, g: (A) => B)(x: A): C = f(g(x))

//Exercise 6

def composeThree[A,B,C,D](f: (C) => D, g: (B) => C, h: (A) => B)(x: A): A => D = (x: A) => f(compose(g, h)(x))

@main def testMethod(): Unit = {
  val empty: String => Boolean = _ == ""
  val notEmpty = negMethod(empty)
  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))
}

@main def testCompose(): Unit = {
  println(compose[Int, Int, Int](_ - 1, _ * 2)(5))
}

@main def testComposeThree(): Unit = {
  println(composeThree((s: String) => s + "!", (n: Int) => n.toString, (n: Int) => n * 2)(3)(3))
}