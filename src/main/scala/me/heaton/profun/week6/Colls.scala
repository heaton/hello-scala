package me.heaton.profun.week6

object Colls {

  def combinate(m: Int, n: Int) = (1 to m) flatMap (x => (1 to n) map (y => (x, y)))

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{ case (x, y) => x * y }.sum

  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)

}
