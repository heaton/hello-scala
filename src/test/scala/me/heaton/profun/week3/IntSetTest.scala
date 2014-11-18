package me.heaton.profun.week3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IntSetTest extends FunSuite {

  test("new set should be .5.") {
    val s = new Root(5)
    assert(s.toString === "{.5.}")
    assert(s.contains(5))
  }

  test("make a set to {{.3.}5{.7.}}") {
    val s = new Root(5).incl(7).incl(3)
    assert(s.toString === "{{.3.}5{.7.}}")
    assert(s.contains(7))
  }

  test("{.3.} union {.5.} should be {{.3.}5.}") {
    val s1 = new Root(3)
    val s2 = new Root(5)
    assert((s1 union s2).toString === "{{.3.}5.}")
  }

  test("{{.3.}7.} union {.5{.9.}} should be {{.3.}5{{.7.}9.}}") {
    val s1 = new Root(7).incl(3)
    val s2 = new Root(5).incl(9)
    assert((s1 union s2).toString === "{{.3.}5{{.7.}9.}}")
  }

}