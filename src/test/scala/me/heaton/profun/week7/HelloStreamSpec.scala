package me.heaton.profun.week7

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import HelloStream._

class HelloStreamSpec extends Specification with Mockito{

  "second prime" should {
    "be the same" in {
      secondPrime === secondPrimeByStream
    }
  }

}
