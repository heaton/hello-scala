package me.heaton.profun.week2_3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RationalTest extends FunSuite {

  test("the result of a rational 1/2 should be 0.5") {
    assert(new Rational(1, 2).result === 0.5)
  }

  test("negative of 1/2 should be -1/2") {
    val r = new Rational(1, 2)
    assert(r.neg.result === -0.5)
  }

  test("1/2 + 1/2 should be 1") {
    val r = new Rational(1, 2)
    assert(r.add(r).result === 1)
  }

  test("1/2 - 1/4 should be 0.25") {
    val r1 = new Rational(1, 2)
    val r2 = new Rational(1, 4)
    assert(r1.sub(r2).result === 0.25)
  }

  test("1/2 * 1/4 should be 0.125") {
    val r1 = new Rational(1, 2)
    val r2 = new Rational(1, 4)
    assert(r1.mul(r2).result === 0.125)
  }

  test("1/2 div 1/4 should be 2") {
    val r1 = new Rational(1, 2)
    val r2 = new Rational(1, 4)
    assert(r1.div(r2).result === 2)
  }

  test("1/3 should be same as 2/6") {
    val r1 = new Rational(1, 3)
    val r2 = new Rational(2, 6)
    assert(r1.equal(r2))
  }

  test("1 - 2/3 - 1/3 should be 0") {
    val r1 = new Rational(1, 1)
    val r2 = new Rational(2, 3)
    val r3 = new Rational(1, 3)
    assert(r1.sub(r2, r3).result === 0)
  }

  test("2/6 should be printed as 1/3") {
    val r = new Rational(2, 6)
    assert(r.toString === "1/3")
  }

  test("3/7 should be less then 3/6") {
    val r1 = new Rational(3, 7)
    val r2 = new Rational(3, 6)
    assert(r1.less(r2))
  }

  test("max of 3/7 and 3/5 should be less then 3/5") {
    val r1 = new Rational(3, 7)
    val r2 = new Rational(3, 5)
    assert(r1.max(r2) === r2)
  }

  test("it should throw an IllegalArgumentException when denominator is 0") {
    intercept[IllegalArgumentException] {
      new Rational(3, 0)
    }
  }

  test("2 should be a rational without a denominator") {
    val r = new Rational(2)
    assert(r.result === 2)
  }

  /**
   * The following table lists the characters in increasing order of priority precedence:
   * (all letters)
   * |
   * ^^
   * &
   * < >
   * = !
   * :
   * + -
   * * / %
   * (all other special characters)
   */
  test("1/2*1/3 + 1/2*1/3 should be 1/3") {
    val x = new Rational(1, 2)
    val y = new Rational(1, 3)
    assert(x * y + x * y == y)
  }

}