package me.heaton.shortestpath

/**
 * Detail for the algorithm
 * https://zh.wikipedia.org/wiki/%E6%88%B4%E5%85%8B%E6%96%AF%E7%89%B9%E6%8B%89%E7%AE%97%E6%B3%95
 */
class Dijkstra(val graph: Graph) {

  def shortest(start: String, end: String): Option[Int] = calculate(end, graph.getEndNodesOf(start))

  def calculate(finalEnd: String, reachableNodes: List[Node]): Option[Int] = reachableNodes.sortBy(_.distance) match {
    case Nil => None
    case head :: _ if head.name == finalEnd => Some(head.distance)
    case Node(name, thisDistance) :: tail => {
      val newHeadLines = graph.getEndNodesOf(name).map(line => line.copy(distance = line.distance + thisDistance))
      calculate(finalEnd, mergeWithMinDistance(tail, newHeadLines))
    }
  }

  private def mergeWithMinDistance(lines1: List[Node], lines2: List[Node]) = (lines1 ::: lines2).groupBy(_.name).toList.map {
    case (name, items) => Node(name, items.map(_.distance).min)
  }

}

case class Node(name: String, distance: Int)
