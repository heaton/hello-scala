package me.heaton.profun.week5

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListSorterTest extends FunSuite {

  /**
   * Convention: Operators(not method calls) ending in ":" associate to the right
   * A :: B :: C is interpreted as A :: (B :: C)
   */
  test("different format of creating a list") {
    assert(7 :: 2 :: 9 :: Nil === List(7, 2, 9))
    assert(Nil.::(9).::(2).::(7) === List(7, 2, 9))
  }

  test("list 7,3,9,2 should be 2,3,7,9 after sorting") {
    assert(ListSorter.isort(List(7, 3, 9, 2)) === List(2, 3, 7, 9))
  }

}