package me.heaton.profun.week5

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PairTupleTest extends FunSuite with TestList {

  test("pair") {
    val pair = ("answer", 42)
    val (s, n) = pair
    assert(s === "answer")
    assert(n === 42)
  }

  test("tuple") {
    val tuple = ("some", "thing", "is", 12) // scala.Tuple4
    val (s, t, i ,n) = tuple
    assert(s === "some")
    assert(t === "thing")
    assert(i === "is")
    assert(n === 12)
  }

}
