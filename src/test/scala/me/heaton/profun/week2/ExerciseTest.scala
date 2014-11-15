package me.heaton.profun.week2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import Exercise._

@RunWith(classOf[JUnitRunner])
class ExerciseTest extends FunSuite {

  test("fixed point should be 2 when the formula is f(x)=1+2/x")(assert(fixedPoint(x => 1 + 2/x)(2) === 2))

}