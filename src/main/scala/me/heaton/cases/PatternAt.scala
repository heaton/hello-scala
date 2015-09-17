package me.heaton.cases

/**
 * @ in match pattern
 */
object PatternAt extends App{

  def f(x: List[Int]): List[Int] = x match {
    case s@List(x, y) => s
    case _ => List(x.sum)
  }

  println(f(List(2, 3)))

  println(f(List(1, 2, 3)))

}
