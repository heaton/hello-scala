package me.heaton.shortestpath

class Dijkstra(val graph: Graph) {

  import Distance.MAX
  
  type NoteWeight = (String, Int)

  def initNotes(start: String) = graph.notes.map((_, MAX))

  def shortest(start: String, end: String): Int = cal((start, 0), end, initNotes(start))

  def cal(start: NoteWeight, end: String, aliveNotes: List[NoteWeight]): Int = aliveNotes match {
    case (note, weight) :: _ if note == end && weight < MAX=> weight
    case notes => {
      val newNotes = mergeTo(notes dropWhile (_ == start), stepOut(start, notes.toMap)).sortBy(_._2)
      cal(newNotes.head, end, newNotes)
    }
  }
  
  def stepOut(start: NoteWeight, aliveNotes: Map[String, Int]): Map[String, Int] = for {
    (note, weight) <- graph.map(start._1)
  } yield (note, weight + start._2)

  def mergeTo(aliveNotes: List[NoteWeight], other: Map[String, Int]): List[NoteWeight] = aliveNotes.map{
    case (key, value) => (key, Math.min(value, other.getOrElse(key, MAX)))
  }
  
}
