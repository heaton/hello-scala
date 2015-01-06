package me.heaton.profun.week6

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import polynomial._

@RunWith(classOf[JUnitRunner])
class PolynomialTest extends FunSuite {

  test("p1") {
    assert(p1.toString === "6.2x^5 + 4x^3 + 2x^1")
  }

  test("p2") {
    assert(p2.toString === "7x^3 + 3")
  }

  test("p1 + p2") {
    assert((p1 + p2).toString === "6.2x^5 + 11x^3 + 2x^1 + 3")
  }

}

