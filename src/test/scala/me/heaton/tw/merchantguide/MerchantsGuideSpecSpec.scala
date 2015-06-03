package me.heaton.tw.merchantguide

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import MerchantsGuide._

class MerchantsGuideSpecSpec extends Specification with Mockito{

  "roman number" should {
    "be parsed form I to 1" in {
      parseRoman("I") === 1
    }
    "be parsed from MCMIII to 1903" in {
      parseRoman("MCMIII") === 1903
    }
    "be parsed from MCMLXXXIX to 1989" in {
      parseRoman("MCMLXXXIX") === 1989
    }
  }

  "currency" should {
    val exchangeRates: ExchangeRate = Map(("Silver", "Credits") -> (2, 34))
    "be converted from 4 Silver to 68 Credits" in {
      convert(Money(4, "Silver"), "Credits", exchangeRates) === Money(68, "Credits")
    }
  }

}
