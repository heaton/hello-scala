package me.heaton.scalaz

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

import MonoidTry._

class MonoidTrySpec extends Specification with Mockito {

  "try monoid" should {
    "have sum of list" in {
      sum(List(1, 2, 3, 4)) ==== 10
      sum(List("a", "b", "c")) ==== "abc"
    }

    "pass other moniod into sum" in {
      val multiMonoid: Monoid[Int] = new Monoid[Int] {
        def mappend(a: Int, b: Int): Int = a * b
        def mzero: Int = 1
      }
      sum3(List(1, 2, 3, 4))(multiMonoid) === 24
    }

    "inject plus into Int and String " in {
      (3 |+| 7) === 10
      ("A" |+| "BC") === "ABC"
    }

  }

}

