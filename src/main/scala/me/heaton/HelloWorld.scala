package me.heaton

object HelloWorld {
  def main(args: Array[String]) {
    println(new Hello().add(1, 2))
    println("Hello, World!")
  }
  
  def add(a: Int, b: Int) {
    a + b
  }

}