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

/**
 * same a
 * def List = new Nil
 * def List[T](x: T) = new Cons(x, new Nil)
 * def List[T](x1: T, x2: T) = new Cons(x1, List(x2))
 */
object List {
  def apply() = new Nil
  def apply[T](x: T): List[T] = new Cons(x, new Nil)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, List(x2))
}