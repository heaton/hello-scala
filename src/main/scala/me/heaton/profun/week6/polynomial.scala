package me.heaton.profun.week6

/**
 * x3 - 2x +5 can be Map(0 -> 5, 1 -> -2, 3 -> 1)
 */
object polynomial {

  class Poly(terms0: Map[Int, Double]) {
    val terms = terms0 withDefaultValue 0.0
    def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }

    override def toString =
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + " replaceAll ("\\.0+x", "x") replaceAll ("x\\^0", "")
  }

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
}
