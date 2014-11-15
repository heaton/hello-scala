package me.heaton.profun.week1

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConditionTest extends FunSuite{

  def loop: Boolean = loop

  test("true and true is true")(assert(Condition.and(true, true))) 

  test("true and false is false")(assert(Condition.and(true, false) == false)) 

  test("false and loop is false")(assert(Condition.and(false, loop) == false)) 

  test("false or false is false")(assert(Condition.or(false, false) == false))

  test("true or loop is true")(assert(Condition.or(true, loop)))

}