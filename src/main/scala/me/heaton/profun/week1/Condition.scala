package me.heaton.profun.week1

object Condition {

  // => call by name
  def and(x: Boolean , y: => Boolean) =
    if (x) y else false

  def or(x: Boolean, y: => Boolean) =
    if(x) true else y

}