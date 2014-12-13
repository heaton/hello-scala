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

  /**
   * merge sort, a faster way to sort. The idea is as follows:
   * If the list consists of zero or one elements, it is already sorted. Otherwise,
   * ▶ Separate the list into two sub-lists, each containing around half of the elements of the original list.
   * ▶ Sort the two sub-lists.
   * ▶ Merge the two sorted sub-lists into a single sorted list.
   *
   * A function takes an implicit parameter of type T. The compiler will search an implicit definition that
   * ▶ is marked implicit
   * ▶ has a type compatible with T
   * ▶ is visible at the point of the function call, or is defined in a companion object associated with T.
   * If there is a single (most specific) definition, it will be taken as actual argument for the implicit parameter.
   * Otherwise it’s an error. (Found nothing or more than one)
   */
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xt, y :: yt) =>
            if(ord.lt(x, y)) x :: merge(xt, ys)
            else y :: merge(xs, yt)
        }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

}
