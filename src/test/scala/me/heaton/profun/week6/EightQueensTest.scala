package me.heaton.profun.week6

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import EightQueens._

@RunWith(classOf[JUnitRunner])
class CollectionsTest extends FunSuite {

  test("not safe if in same column") {
    assert(isSafe(1, 1 :: List()) === false)
  }

  test("not safe if in right up") {
    assert(isSafe(2, 1 :: List()) === false)
  }

  test("not safe if in left up") {
    assert(isSafe(0, 1 :: List()) === false)
  }

  test("safe if in other spot") {
    assert(isSafe(3, 1 :: List()) === true)
  }

  test("not safe if can be killed by one of the queens") {
    assert(isSafe(1, 0 :: 2 :: List()) === false)
  }

  test("safe if can not be killed by any queens") {
    assert(isSafe(1, 3 :: 0 :: 2 :: List()) === true)
  }

  test("queens in 4") {
    assert(queens(4) === Set(List(1, 3, 0, 2), List(2, 0, 3, 1)))
  }

}

