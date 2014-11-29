package me.heaton.profun.week4

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExprPMTest extends FunSuite {

  test("eval sum of 2 and 3 is 5") {
    assert(SumPM(NumberPM(2), NumberPM(3)).eval === 5)
  }

  test("show Number 10 is 10") {
    assert(NumberPM(10).show === "10")
  }

  test("show Sum of 5 and 10 is '5 + 10'") {
    assert(SumPM(NumberPM(5), NumberPM(10)).show === "5 + 10")
  }

  test("show variable x is x") {
    assert(VarPM("x").show === "x")
  }

  test("show x prod 5 is 'x * 5'") {
    assert(ProdPM(VarPM("x"), NumberPM(5)).show === "x * 5")
  }

  test("show 2 * x + y") {
    assert(SumPM(ProdPM(NumberPM(2), VarPM("x")), VarPM("y")).show === "2 * x + y")
  }

  test("show (2 + x) * y") {
    assert(ProdPM(SumPM(NumberPM(2), VarPM("x")), VarPM("y")).show === "(2 + x) * y")
  }

  test("show y * (2 + x)") {
    assert(ProdPM(VarPM("y"), SumPM(NumberPM(2), VarPM("x"))).show === "y * (2 + x)")
  }

  test("show (2 + x) * (3 + y)") {
    assert(ProdPM(SumPM(NumberPM(2), VarPM("x")), SumPM(NumberPM(3), VarPM("y"))).show === "(2 + x) * (3 + y)")
  }

  test("show 2 * (x + y + z)") {
    assert(ProdPM(NumberPM(2), SumPM(VarPM("x"), SumPM(VarPM("y"), VarPM("z")))).show === "2 * (x + y + z)")
  }

}