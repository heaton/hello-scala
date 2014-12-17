package me.heaton.profun.week6

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CollectionsTest extends FunSuite with SomeInstances {

  test("Vector") {
    assert((12 +: nums).head === 12)
    assert((people :+ "Heaton").last === "Heaton")
  }

  test("Array") {
    val xs: Array[Int] = Array(1, 2, 3)
    assert((xs map (2 * _)) === Array(2, 4, 6))
  }

  test("filter") {
    assert((s filter (c => c.isUpper)) === "HW")
  }

  test("exists") {
    assert((s exists (c => c.isUpper)) === true)
  }

  test("forall") {
    assert((s forall (c => c.isUpper)) === false)
  }

  test("zip") {
    val pairs = List(1, 2, 3) zip s
    assert(pairs === List((1, 'H'), (2, 'e'), (3, 'l')))
    assert(pairs.unzip ===(List(1, 2, 3), List('H', 'e', 'l')))
  }

  test("flatMap") {
    assert(s.flatMap(List('.', _)) === ".H.e.l.l.o. .W.o.r.l.d")
  }

  test("cals") {
    assert(nums.sum === -82)
    assert(nums.product === 1 * 2 * 3 * -88)
    assert(nums.max === 3)
    assert(nums.min === -88)
  }

  test("Range") {
    val r: Range = 1 until 5 // 1, 2, 3, 4
    val s: Range = 1 to 5 // 1, 2, 3, 4, 5
    val r2 = 1 to 10 by 3 // 1, 4, 7, 10
    val r3 = 6 to 1 by -2 // 6, 4, 2
    assert(r.head === 1)
    assert(r.last === 4)
    assert(s.head === 1)
    assert(s.last === 5)
    assert(r2.length === 4)
    assert(r3.length === 3)
  }

  test("combinations") {
    assert(Colls.combinate(2, 3) === Vector((1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3)))
  }

  test("scalar product") {
    assert(Colls.scalarProduct(Vector(4.0, 2.0), dous) === 8)
  }

  test("is prime") {
    assert(Colls.isPrime(4) === false)
    assert(Colls.isPrime(19) === true)
  }
}

trait SomeInstances {
  val nums = Vector(1, 2, 3, -88)
  val dous = Vector(1.0, 2.0, 4.0)
  val people = Vector("Bob", "James", "Peter")
  val s = "Hello World"
}
