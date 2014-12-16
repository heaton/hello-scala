package me.heaton

object HelloApp extends App {
  println("Hello App");

  class IntWrapper(i: Int) {
    def **(n: Int) = {
      Math.pow(i, n)
    }
  }

  implicit def intWrapper(i: Int) = new IntWrapper(i)

  def f(n: Int): Double = -1 ** (n - 1) * 1.0 / (2 * n - 1)

  def pi4(p: Int): Double = {
    def pi4Acc(n: Int, acc: Double): Double = n match {
      case 1 => 1 + acc
      case _ => pi4Acc(n - 1, f(n) + acc)
    }
    pi4Acc(p, 0)
  }

  def pi(p: Int) = pi4(p) * 4

  val now = System.currentTimeMillis()
  println(pi(100000))
  println(System.currentTimeMillis() - now)

}