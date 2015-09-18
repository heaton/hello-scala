package me.heaton.functions

object PartialFunctions extends App{

  val one: PartialFunction[Int, String] = {
    case 1 => "one"
    case 2 => "two"
  }

  println(one isDefinedAt 1)
  println(one isDefinedAt 3)

}
