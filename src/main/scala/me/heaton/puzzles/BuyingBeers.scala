package me.heaton.puzzles

object BuyingBeers extends App{

  def buyMore(bears: Int, bottlesLeft: Int, capsLeft: Int) =
    bears + buy(bears + bottlesLeft, bears + capsLeft)

  def buy(bottles: Int, caps: Int): Int =
    if(bottles<2 && caps<4) 0
    else buyMore(bottles/2 + caps/4,  bottles%2, caps%4)

  def buy(money: Int): Int = money/2 + buy(money/2, money/2)

  println(buy(10))

  def buy2(money: Int): Int = {
    def guessMaxBeers(bottles: Int): Int =
      if(bottles/2 + bottles/4 + money/2 == bottles) bottles
      else guessMaxBeers(bottles + 1)
    guessMaxBeers(1)
  }

  println(buy2(10))

}
