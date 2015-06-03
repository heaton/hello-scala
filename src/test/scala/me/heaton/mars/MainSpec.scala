package me.heaton.mars

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class MainSpec extends Specification with Mockito{

  "Rover" should {

    "moves from 12N from 13N by command LMLMLMLMM" in {
      Command("LMLMLMLMM")(new State(1, 2, N)) === new State(1, 3, N)
    }

    "moves from 33E from 51E by command MMRMMRMRRM" in {
      Command("MMRMMRMRRM")(new State(3, 3, E)) === new State(5, 1, E)
    }

  }

}
