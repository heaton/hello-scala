package me.heaton.shortestpath

class Floyd(graph: Graph) {

  def shortest(start: String, end: String) = cal(start, end, graph.notes)

  def cal(start: String, end: String, notes: List[String]): Int = notes match {
    case Nil => graph.distance(start, end)
    case note :: rest => Math.min(cal(start, note, rest) + cal(note, end, rest), cal(start, end, rest))
  }

}

class Graph(val input: String) {

  import Distance.MAX

  val map: Map[String, Map[String, Int]] = input.split(",").map(_.trim).groupBy(_.head.toString).mapValues({
    case array => array.map(s => (s(1).toString, s.last.toString.toInt)).toMap.withDefaultValue(MAX)
  })

  def note(s: String) = map(s)

  def notes: List[String] = input.filter(_.isLetter).distinct.map(_.toString).toList

  def distance(from: String, to: String): Int = map(from)(to)

}

object Distance {
  val MAX = 100;
}

