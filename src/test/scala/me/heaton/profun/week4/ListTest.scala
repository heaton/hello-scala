package me.heaton.profun.week4

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListTest extends FunSuite {

  def nth[T](n: Int, xs: List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n === 0) xs.head
    else nth(n - 1, xs.tail)

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

  test("the third element in the list should be 3") {
    assert(nth(2, list) === 3)
  }

  test("should throw an IndexOutOfBoundsException when get an index out of the size") {
    intercept[IndexOutOfBoundsException]{
      nth(3, list)
    }
  }

}