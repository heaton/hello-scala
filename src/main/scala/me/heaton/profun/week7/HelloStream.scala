package me.heaton.profun.week7

import me.heaton.profun.week6.Colls._

/**
 * Streams are similar to lists, but their tail is evaluated only on demand.
 * Stream.cons(head, tail) // tail is call by name
 */
object HelloStream {

  def streamRange(lo: Int, hi: Int): Stream[Int] =
    if (lo >= hi) Stream.empty
    else lo #:: streamRange(lo + 1, hi)

  val secondPrime = ((1000 to 10000).toStream filter isPrime)(1)

  val secondPrimeByStream = (streamRange(1000, 10000) filter isPrime)(1)

}
