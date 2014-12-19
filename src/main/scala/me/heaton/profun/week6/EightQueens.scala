package me.heaton.profun.week6

object EightQueens extends App{

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
    }
    placeQueens(n)
  }

  def isSafe(col: Int, queens: List[Int]) = {
    val row = queens.length
    queens.withRow forall {
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }

  def show(queens: List[Int]): String = {
    val lines = for (col <- queens.reverse) yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines mkString "\n")
  }

  case class ListWrap(queens: List[Int]) {
    def withRow: Seq[(Int, Int)] = {
      val row = queens.length
      (row - 1 to 0 by -1) zip queens
    }
  }

  implicit def warp(queens: List[Int]): ListWrap = ListWrap(queens)

  println(queens(8) take 3 map show mkString "\n")

}
