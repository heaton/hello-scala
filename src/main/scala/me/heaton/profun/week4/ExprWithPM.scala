package me.heaton.profun.week4

/**
 * Expression with Pattern Matching
 */
trait ExprWithPM {

  /**
   * A MatchError exception is thrown if no pattern matches the value of selector
   *
   * Patterns are constructed from:
   * constructors
   * variables (Always begin with a lowercase letter and no repetition)
   * wildcard patterns _
   * constants (Always begin with a Capital letter except null, true, false)
   */
  def eval: Int = this match {
    case NumberPM(n) => n
    case SumPM(e1, e2) => e1.eval + e2.eval
  }

  def show: String = this match {
    case NumberPM(n) => n.toString
    case SumPM(e1, e2) => e1.show + " + " + e2.show
    case VarPM(x) => x
    case ProdPM(e1, e2) => Priority(e1).show + " * " + Priority(e2).show
  }
}

/**
 * Case class implicitly defines companion objects with apply methods.
 *
 * object NumberPM { def apply(n: Int) = new Number(n) }
 */
case class NumberPM(n: Int) extends ExprWithPM

case class SumPM(e1: ExprWithPM, e2: ExprWithPM) extends ExprWithPM

case class VarPM(x: String) extends ExprWithPM

case class ProdPM(e1: ExprWithPM, e2: ExprWithPM) extends ExprWithPM

case class Priority(e: ExprWithPM) extends ExprWithPM {
  override def show: String = e match {
    case e: SumPM => "(" + e.show + ")"
    case _ => e.show
  }
}
