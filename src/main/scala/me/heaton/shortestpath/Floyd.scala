package me.heaton.shortestpath

class Floyd(graph: Graph) {

  def shortest(start: String, end: String) = calulate(start, end, graph.nodes)

  def calulate(start: String, end: String, notes: List[String]): Option[Int] = notes match {
    case Nil => graph.getEndNodesOf(start).find(_.name == end).map(_.distance)
    case head :: rest => (calulate(start, head, rest), calulate(head, end, rest), calulate(start, end, rest)) match {
      case (Some(a), Some(b), Some(c)) => Some(Seq(a + b, c).min)
      case (Some(a), Some(b), _) => Some(a + b)
      case (_, _, Some(c)) => Some(c)
      case _ => None
    }
  }

}

class Graph(val input: String) {

  private val inputLines = input.split(",").map(_.trim).toList.map {
    _.toCharArray.map(_.toString) match {
      case Array(start, end, weight) => (start, Node(end, weight.toInt))
    }
  }

  private val map: Map[String, List[Node]] = inputLines.groupBy(_._1).mapValues(_.map(_._2))

  def getEndNodesOf(start: String): List[Node] = map.getOrElse(start, Nil)

  def nodes: List[String] = inputLines.flatMap(line => Seq(line._1, line._2.name)).distinct

}

