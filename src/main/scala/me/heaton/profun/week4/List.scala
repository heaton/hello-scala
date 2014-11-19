package me.heaton.profun.week4

/**
 * A trait is declared <b>like</b> an abstract class, just with trait instead of abstract class.
 *
 * Type parameters do not affect evaluation in Scala. It's called type erasure. See 3.3
 */
trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true

  def head = throw new NoSuchElementException("Nil.head")

  def tail = throw new NoSuchElementException("Nil.tail")
}
