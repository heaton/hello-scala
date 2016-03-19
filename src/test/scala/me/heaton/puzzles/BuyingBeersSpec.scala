package me.heaton.puzzles

import org.specs2.mock.Mockito
import org.specs2.mutable._

class BuyingBeersSpec extends Specification with Mockito {

  import BuyingBeers._

  "BuyingBeers" should {
    "get the same results in buy and buy2" in {
      buy(10) === 15
      buy(10) === buy2(10)
      buy(15) === buy2(15)
      buy(20) === buy2(20)
      buy(50) === buy2(50)
    }
  }

}
