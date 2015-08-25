package me.heaton.implicits

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class FunctionImpSpec extends Specification {

  import FunctionImp._

  "function getLarge" should {
    "get the more count one between two geiven thing" in {
      getLarge("Hello World", "Hi") === "Hello World"
      getLarge(5, 4) === 5
    }
  }

}
