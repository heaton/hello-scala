package me.heaton.profun.week4

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NatTest extends FunSuite {

  def v(n: Nat): Int = if (n.isZero) 0 else (v(n.predecessor) + 1)

  test("Zero is 0") {
    assert(v(Zero) === 0)
  }

  test("Nat 1") {
    assert(v(Zero.successor) === 1)
  }

  test("3.pre is 2") {
    val three = Zero.successor.successor.successor
    assert(v(three.predecessor) === 2)
  }

  test("2 + 3 = 5") {
    val two = Zero.successor.successor
    val three = Zero.successor.successor.successor
    assert(v(two + three) === 5)
  }

  test("3 - 2 = 1") {
    val two = Zero.successor.successor
    val three = Zero.successor.successor.successor
    assert(v(three - two) === 1)
  }

  test("0-0 = 0") {
    assert(v(Zero - Zero) === 0)
  }

}