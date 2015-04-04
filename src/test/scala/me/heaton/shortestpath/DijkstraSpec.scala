package me.heaton.shortestpath

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class DijkstraSpec extends Specification with Mockito{

  val graph = new Graph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7")
  val dijkstra = new Dijkstra(graph)

  "the shortest path of A to C" should {
    "be 9" in {
       dijkstra.shortest("A", "C") === 9
    }
  }

  "the shortest path of B to B" should {
    "be 9" in {
      dijkstra.shortest("B", "B") === 9
    }
  }

}
