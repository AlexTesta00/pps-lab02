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
def negMethod(f: (String) => Boolean): (String) => Boolean = {
  (x: String) => !f(x)
}

@main def testMethod() = {
  val empty: String => Boolean = _ == ""
  val notEmpty = neg(empty)
  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))
}