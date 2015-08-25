package me.heaton.implicits

object FunctionImp {

  sealed trait Countable[T] {
    def count(t: T): Int
  }

  def getLarge[T](a: T, b: T)(implicit countable: Countable[T]) =
    if(countable.count(a) > countable.count(b)) a
    else b

  implicit lazy val stringCounter = new Countable[String] {
    def count(t: String): Int = t.split(" ").length
  }

  implicit lazy val intCounter = new Countable[Int] {
    def count(t: Int): Int = t
  }

}
