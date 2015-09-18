package me.heaton.functions

object Operators extends App{

  def f(s: String) = "f(" + s + ")"

  def g(s: String) = "g(" + s + ")"

  val fs = new Functions(f, g)

  println(fs.compose("x"))
  println(fs.andThen("x"))
}

case class Functions(f: String => String, g: String => String) {
  /**
   * compose -> f(g(x))
   */
  def compose = f compose g

  /**
   * andTen -> g(f(x))
   */
  def andThen = f andThen g
}
