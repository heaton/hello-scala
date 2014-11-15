package me.heaton.profun.week2

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TailRecursionTest extends FunSuite {

  test("gcd of 14 and 21 is 7")(assert(TailRecursion.gcd(14, 21) === 7))

  test("factorial of 4 is 24")(assert(TailRecursion.factorial(4) === 24))

  test("tail_factorial of 4 is 24") {
    assert(TailRecursion.tailFactorial(4) === 24)
  }

}