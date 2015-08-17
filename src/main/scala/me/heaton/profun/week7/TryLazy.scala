package me.heaton.profun.week7

object TryLazy extends App {

  val x = {
    print("x");
    1
  }

  /**
   * lazy evaluation (computed at first time using)
   */
  lazy val y = {
    print("y"); 2
  }

  def z = {
    print("z"); 3
  }

  z + y + x + z + y + x // xzyz

}
