package me.heaton.profun.week7

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class WaterPouringSpec extends Specification with Mockito{

  "A move Pour" should {

    val pooling = new WaterPooling(Vector(4, 9))

    "get (0/4) from (4/0) when pour from 0 to 1" in {
      pooling.Pour(0, 1).change(Vector(4, 0)) === Vector(0, 4)
    }

    "get (3/9) from (4/8) when pour from 0 to 1" in {
      pooling.Pour(0, 1).change(Vector(4, 8)) === Vector(3, 9)
    }

    "get (0/9) from (4/5) when pour from 1 to 0" in {
      pooling.Pour(1, 0).change(Vector(0, 9)) === Vector(4, 5)
    }

  }

  "WaterPooling" should {
    "find a solution of a puzzle" in {
      val pooling = new WaterPooling(Vector(4, 9))
      pooling.solutions(6).head.endState contains 6
    }

    "not find a solution if the puzzle has no answer" in {
      val pooling = new WaterPooling(Vector(4, 10))
      pooling.solutions(5).isEmpty
    }
  }

}
