package me.heaton.profun.week4

/**
 * A trait is declared <b>like</b> an abstract class, just with trait instead of abstract class.
 *
 * Type parameters do not affect evaluation in Scala. It's called type erasure. See 3.3
 *
 * Variance: (TP = type parameters)
 * class C[+T]: C is covariant     // C[O <: T] <: C[T]
 * class C[-T]: C is contravariant // C[O >: T] <: C[T]
 * class C[T] : C is invariant
 *
 * Liskov Substitution Principle (LSP)
 * covariant TP can only appear in method results
 * contravariant TP can only appear in method parameters
 * invariant TP can appear anywhere
 *
 * so List is a covariant class
 */
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
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
  def apply() = Nil
  def apply[T](x: T): List[T] = new Cons(x, Nil)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, List(x2))
}