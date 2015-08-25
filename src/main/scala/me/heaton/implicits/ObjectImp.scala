package me.heaton.implicits

object ObjectImp {

  case class IntWrapper(i: Int) {
    def **(n: Int) = Math.pow(i, n)
  }

  implicit def _wrapper(i: Int): IntWrapper = IntWrapper(i)

}
