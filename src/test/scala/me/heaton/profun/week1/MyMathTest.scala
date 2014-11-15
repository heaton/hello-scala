package me.heaton.profun.week1

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MyMathTest extends FunSuite{

  def approximate(x: Double, y: Double, accuracy: Double): Boolean = 
    Math.abs(x - y) <= accuracy

  test("1 sqrt is 1")(assert(MyMath.sqrt(1) === 1)) 

  test("2 sqrt is about 1.4142"){
    assert(approximate(MyMath.sqrt(2), 1.4142, 0.0001))
  }

}