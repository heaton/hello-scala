package me.heaton.implicits

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class ObjectImpSpec extends Specification {

  import ObjectImp._

  "**" should {
    "be pow of math" in {
      1 ** 2 === 1
      3 ** 2 === 9
    }
  }

}
