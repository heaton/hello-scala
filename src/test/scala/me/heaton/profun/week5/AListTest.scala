package me.heaton.profun.week5

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AListTest extends FunSuite with TestList {

  /**
   * Convention: Operators(not method calls) ending in ":" associate to the right
   * A :: B :: C is interpreted as A :: (B :: C)
   */
  test("different format of creating a list") {
    assert(7 :: 2 :: 9 :: Nil === List(7, 2, 9))
    assert(Nil.::(9).::(2).::(7) === List(7, 2, 9))
  }

  test("list 7,3,9,2 should be 2,3,7,9 after sorting") {
    assert(AList.isort(List(7, 3, 9, 2)) === List(2, 3, 7, 9))
  }

  test("++ should be same as ::: on List type") {
    assert(l4 ++ lo === l4 ::: lo)
  }

  test("last of 1,2,3,4 should be 4") {
    assert(AList.last(l4) === 4)
  }

  test("init of 1,2,3,4 should be 4") {
    assert(AList.last(l4) === 4)
  }

  test("concat 1,2,3,4 and 5,6 should be 1,2,3,4,5,6") {
    assert(AList.concat(l4, lo) === List(1, 2, 3, 4, 5, 6))
  }

  test("reverse 1,2,3,4 should be 4,3,2,1") {
    assert(AList.reverse(l4) === List(4, 3, 2, 1))
  }

  test("removeAt index 1 of 1,2,3,4 should return 1,3,4") {
    assert(AList.removeAt(l4, 1) === List(1, 3, 4))
  }

  test("flatten") {
    assert(AList.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) === List(1, 1, 2, 3, 5, 8))
  }

  test("list 7,6,4,3,9,2 should sort to 2,3,4,6,7,9 by merge sort") {
    assert(AList.msort(List(7, 6, 4, 3, 9, 2)) === List(2, 3, 4, 6, 7, 9))
  }

  test("list pear,apple,peach,orange,pineapple should sort to apple,orange,peach,pear,pineapple by merge sort") {
    assert(AList.msort(List("pear", "apple", "peach", "orange", "pineapple")) === List("apple", "orange", "peach", "pear", "pineapple"))
  }

  test("map") {
    assert((List(1, 2) map (_ + 1)) === List(2, 3))
  }

  test("filter") {
    assert((al filter (_ > 0)) === List(2, 5, 7, 8))
    assert((al filterNot (_ > 0)) === List(-2, -3))
    assert((al partition (_ > 0)) ===(List(2, 5, 7, 8), List(-2, -3)))
  }

  test("take while") {
    assert((al takeWhile (_ > 0)) === List(2, 5))
    assert((al dropWhile (_ > 0)) === List(-2, 7, -3, 8))
    assert((al span (_ > 0)) ===(List(2, 5), List(-2, 7, -3, 8)))
  }

  test("pack") {
    assert(AList.pack(sl) === List(List("a", "a", "a"), List("b", "b"), List("c"), List("a")))
  }

  test("encode") {
    assert(AList.encode(sl) === List(("a", 3), ("b", 2), ("c", 1), ("a", 1)))
  }

  test("sum by reduce left") {
    assert(AList.sum(el) === 0)
    assert(AList.sum(l4) === 10)
  }

  test("product by fold left") {
    assert(AList.product(el) === 1)
    assert(AList.product(l4) === 24)
  }

  test("concat by flod right") {
    assert(AList.concat2(l4, lo) === List(1, 2, 3, 4, 5, 6))
  }

  test("new reverse") {
    assert(AList.reverse2(l4) === List(4, 3, 2, 1))
  }

}

trait TestList {
  val el = List()
  val l4 = List(1, 2, 3, 4)
  val lo = List(5, 6)
  val al = List(2, 5, -2, 7, -3, 8)
  val sl = List("a", "a", "a", "b", "b", "c", "a")
}
