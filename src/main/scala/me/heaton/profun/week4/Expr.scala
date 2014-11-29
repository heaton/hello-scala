package me.heaton.profun.week4

/**
 * Something in session 4.5
 * def isInstanceOf[T]: Boolean
 * def asInstanceOf[T]: T
 */
trait Expr {
  def eval: Int
}

class Number(n: Int) extends Expr{
  def eval: Int = n
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def eval: Int = e1.eval + e2.eval
}

/**
 * What are the trade-offs to do it with pattern matching or with the previous object-oriented decompositions solution?
 * One criteria could be, are you more often creating new sub-classes of expression or are you more often creating new methods?
 * If what you do is mostly creating new subclasses, then actually the object oriented decomposition solution has the upper hand.
 * If what you do will be create lots of new methods. But the class hierarchy itself will be kept relatively stable. Then pattern matching is actually advantageous.
 */