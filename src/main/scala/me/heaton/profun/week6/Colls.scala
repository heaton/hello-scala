package me.heaton.profun.week6

object Colls {

  /**
   * xs flatMap f = (xs map f).flatten
   */
  def combinate(m: Int, n: Int) = (1 to m) flatMap (x => (1 to n) map (y => (x, y)))

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{ case (x, y) => x * y }.sum

  def scalarProductFromFor(xs: Vector[Double], ys: Vector[Double]): Double =
    (for ((x, y) <- xs zip ys) yield x * y).sum

  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)

  /**
   * Given a positive integer n, find all pairs of positive integers i and j, with 1 <= j < i < n such that i + j is prime
   */
  def pairs(n: Int) = ((2 until n) map (i => (1 until i) map (j => (i, j)))).flatten filter {case (i, j) => isPrime(i + j)}

  def pairsFromFor(n: Int) = for {
    i <- 2 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)

}

case class People(name: String, age: Int)

