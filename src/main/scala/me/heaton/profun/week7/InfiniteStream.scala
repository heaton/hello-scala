package me.heaton.profun.week7

object InfiniteStream extends App {

  def from(n: Int): Stream[Int] = n #:: from(n+1)

  val nats = from(0)
  val m4s = nats map (_ * 4)

  println((m4s take 100).toList)

  /**
   * The Sieve of Eratosthenes is an ancient technique to calculate prime numbers.
   */
  def sieve(s: Stream[Int]): Stream[Int] = s.head #:: sieve(s.tail filter (_ % s.head != 0))

  def primes = sieve(from(2))

  println(primes.take(100).toList)

  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }

  def isGoodEnough(guess: Double, x: Double) =
    math.abs((guess * guess - x) / x) < 0.0001

  println(sqrtStream(4) filter (isGoodEnough(_, 4)) take 10 toList)

}