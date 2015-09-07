package me.heaton.spec2

import org.specs2.mutable.Specification

class SomeSpec extends Specification {

  "Heaton" should {
    "say hello to you" in {
      (List("Hello", "there!") mkString " ") === "Hello there!"
    }
  }

}
