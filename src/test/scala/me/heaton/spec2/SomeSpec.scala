package me.heaton.spec2

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class SomeSpec extends Specification with Mockito{

  "1+2" should {
    "= 3" in {
      1 + 2 === 3
    }
  }

}
