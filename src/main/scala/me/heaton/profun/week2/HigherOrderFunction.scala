package me.heaton.profun.week2

object HigherOrderFunction {

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      def loop(a: Int, acc: Int): Int = {
        if (a > b) acc
        else loop(a + 1, f(a) + acc)
      }
      loop(a, 0)
    }
    sumF
  }

  def product(f: Int => Int): (Int, Int) => Int = {
    def productF(a: Int, b: Int): Int =
      if (a > b) 1 else f(a) * productF(a + 1, b)
    productF
  }

  def id(x: Int): Int = x

  def fact(x: Int): Int = TailRecursion.factorial(x)

  def fact2(n: Int): Int = productInts(1, n)

  def sumInts = sum(id)

  def sumFactorials = sum(fact)

  def productInts = product(id)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  def sum2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

}
