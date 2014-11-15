package me.heaton.profun.week2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import HigherOrderFunction._

@RunWith(classOf[JUnitRunner])
class HigherOtherFunctionTest extends FunSuite {

  test("sum double from 3 to 5 is 50")(assert(sum(x => x * x)(3, 5) === 50))

  test("sum int from 2 to 5 is 14")(assert(sumInts(2, 5) === 14))

  test("sum factorial from 2 to 3 is 8")(assert(sumFactorials(2, 3) === 8))

  test("sum factorial with fact2 from 2 to 3 is 8")(assert(sum(fact2)(2, 3) === 8))

  test("product int from 2 to 5 is 120")(assert(productInts(2, 5) === 120))

  test("sum2 should be same as sum")(assert(sum2(x => x * x)(3, 5) === 50))

  test("product2 should be same as product")(assert(product2(x => x)(2, 5) === 120))

}