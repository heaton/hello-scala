package me.heaton.profun.week5

object ListSorter {

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if(x < y) x :: xs else y :: insert(x, ys)
  }

}
