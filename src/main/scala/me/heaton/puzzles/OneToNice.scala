package me.heaton.puzzles

object OneToNice extends App{

  def puzzle = cal((1 to 9).toList) map (_.reverse)

  def cal(r: List[Int]): Set[List[Int]] =
    if(r.isEmpty) Set(List())
    else (for {
      n <- r
      ns <- cal(r.filter(_ != n))
      if isMatch(n :: ns)
    } yield n :: ns).toSet

  def isMatch(ns: List[Int]): Boolean = ns match {
    case e :: d :: c :: b :: a :: Nil => (a * 10 + b) * c == (d * 10 + e)
    case i :: h :: g :: f :: e :: d :: c :: b :: a :: Nil => (d * 10 + e) + (f * 10 + g) == (h * 10 + i)
    case _ => true
  }

  def show(ns: List[Int]) = print(
    s"""
       |  ${ns(0)} ${ns(1)}
       |x   ${ns(2)}
       |------
       |  ${ns(3)} ${ns(4)}
       |+ ${ns(5)} ${ns(6)}
       |------
       |  ${ns(7)} ${ns(8)}
       |
     """.stripMargin)

  puzzle foreach show

}
