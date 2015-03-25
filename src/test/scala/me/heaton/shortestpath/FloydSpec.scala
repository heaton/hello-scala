package me.heaton.shortestpath

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class FloydSpec extends Specification with Mockito{

  val graph = new Graph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7")
  val floid = new Floyd(graph)

  "the shortest path of A to C" should {
    "be 9" in {
       floid.shortest("A", "C") === 9
    }
  }

  "the shortest path of B to B" should {
    "be 9" in {
      floid.shortest("B", "B") === 9
    }
  }

}
