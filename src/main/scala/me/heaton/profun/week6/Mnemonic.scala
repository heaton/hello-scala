package me.heaton.profun.week6

import scala.io.Source

object Mnemonic {

  val inPath = getClass().getResource("/profun/forcomp/linuxwords.txt");

  val in = Source.fromURL(inPath)
  val words = in.getLines().toList filter (_ forall (_.isLetter))

  val mnem = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
  )

  val charCode: Map[Char, Char] = for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit

  def wordCode(word: String): String = word.toUpperCase map charCode

  def wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue Seq()

  def encode(number: String): Set[List[String]] =
    if(number.isEmpty) Set(List())
    else (
      for {
        spilt <- 1 to number.length
        word <- wordsForNum(number take spilt)
        rest <- encode(number drop spilt)
      } yield word :: rest
    ).toSet

  def translate(number: String): Set[String] = encode(number) map (_ mkString " ")

}
