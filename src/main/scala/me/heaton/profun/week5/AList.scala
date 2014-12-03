package me.heaton.profun.week5

/**
 * List Basic Methods
 * xs.length
 * xs.last
 * xs.init : all elements expect last
 * xs take n : first n elements
 * xs drop n : the rest of take n
 * xs(n) : element at index n
 *
 * xs ++ ys : add all
 * xs.reverse
 * xs updated (n, x) : change the element at index n to x
 *
 * xs indexOf x
 * xs contains x
 */
object AList {

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
  }

  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y)
  }

  def removeAt[T](xs: List[T], n: Int): List[T] = (xs take n) ::: (xs drop n + 1)

  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case (y: List[Any]) :: ys => flatten(y) ::: flatten(ys)
    case y :: ys => y :: flatten(ys)
  }

}
