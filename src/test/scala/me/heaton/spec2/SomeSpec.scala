package me.heaton.spec2

import org.specs2.matcher.{Expectable, Matcher}
import org.specs2.mock.Mockito
import org.specs2.mutable._
import org.specs2.specification.Scope

/**
 * https://etorreborre.github.io/specs2/guide/SPECS2-2.4.17/org.specs2.guide.Structure.html
 */
class SomeSpec extends Specification with Mockito {

  step {
    "first setp".pp
  }

  "Heaton" should {
    "say hello to you" in {
      (List("Hello", "there!") mkString " ") === "Hello there!"
    }
  }

  "Spec2" should {
    "help us" in {
      "write some tests" in {
        (1 + 2) mustEqual 3
        "hello" must be matching "h.*"
      }

      "write some other tests" in {
        val numbers = List(1, 2, 3)
        numbers must contain(1)
        numbers must not contain 4

        numbers must containAllOf(List(2, 1, 3))
      }

      "and other tests" in {
        5 must be greaterThan 4
        6.5 must beCloseTo(6.4, 0.1)
      }

      "and options" in {
        Some("Heaton") must beSome[String]
        Some("Heaton") must beSome("Heaton")
        None must beNone
      }

      //a must throwA[WhateverException]
      //a must throwA(WhateverException("message"))
      //a must throwA(new Exception) like {
      // case Exception(m) => m.startsWith("bad")
      //}
    }

    "let us create our own Matcher" in {
      case class SumOf(a: Int) extends Matcher[List[Int]] {
        def apply[S <: List[Int]](x: Expectable[S]) =
          result(x.value.sum == a, "OK", "Not OK", x)
      }
      List(1,2,3) must SumOf(6)
    }

    "has mocks" in {

      trait AClass[T] {
        def get(i: Int): T
      }

      "nomarl mocks" in {
        val m = mock[AClass[String]]

        m.get(0) returns "one"
        m.get(0) === "one"

        there was one(m).get(0)
        there was no(m).get(1)
      }

      "try spy" in {
        class AnotherClass extends AClass[String] {
          override def get(i: Int): String = i.toString
        }
        val c = new AnotherClass

        c.get(1) === "1"

        val c2 = spy(c)
        c2.get(0) returns "zero"
        c2.get(0) === "zero"
      }

      "try spy object" in {
        object AObject extends AClass[String] {
          override def get(i: Int): String = i.toString
        }

        val o = spy(AObject)
        o.get(0) returns "zero"
        o.get(0) === "zero"
      }
    }

    "has isolation with Scope" in new aScope {
      list.size === 4
    }

    "has before and after" in new BA {
      println("here is BA test")
      1 === 1
    }

  }

  step {
    "last setp".pp
  }

  trait aScope extends Scope {
    val list = List(1, 2, 3, 4)
  }

  trait BA extends BeforeAfter {
    def before = println("I'm before")
    def after = println("You now see me")
  }

}
