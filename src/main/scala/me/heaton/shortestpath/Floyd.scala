package me.heaton.shortestpath

class Floyd(graph: Graph) {

  def shortest(start: String, end: String) = cal(start, end, graph.notes)

  def cal(start: String, end: String, notes: List[String]): Int = notes match {
    case Nil => graph.distance(start, end)
    case note :: rest => Math.min(cal(start, note, rest) + cal(note, end, rest), cal(start, end, rest))
  }

}

class Graph(val input: String) {

  val map: Map[String, Int] = input.split(",").map(_.trim).map(s => (s.dropRight(1), s.last.toString.toInt)).toMap.withDefaultValue(100)

  def notes: List[String] = input.filter(_.isLetter).distinct.map(_.toString).toList

  def distance(from: String, to: String): Int = map(from + to)

}
