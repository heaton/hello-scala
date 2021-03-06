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

  test("last {{.3.}7.} union {.5{.9.}} should be {{.3.}5{{.7.}9.}}") {
    val s1 = new Root(10).incl(5).incl(3).incl(7).incl(20).incl(15).incl(22)
    val s2 = new Root(8).incl(6).incl(4).incl(9).incl(7).incl(10)
    assert((s1 union s2).toString === "{{{{.3.}4{.5.}}6{.7.}}8{.9{.10{{.15.}20{.22.}}}}}")
  }

}