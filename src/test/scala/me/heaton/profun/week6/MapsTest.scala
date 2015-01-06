package me.heaton.profun.week6

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import maps._

@RunWith(classOf[JUnitRunner])
class MapsTest extends FunSuite {

  test("the capital of US is Washington") {
    assert(capitalOfCountry("US") === "Washington")
  }

  test("throw NoSuchElementException when ask the capital of Andorra") {
    intercept[NoSuchElementException]{
      capitalOfCountry("Andorra")
    }
  }

  test("be None when get the capital of Andorra") {
    assert((capitalOfCountry get "Andorra") === None)
  }

  test("be Some(Washington) when get the capital of US") {
    assert((capitalOfCountry get "US") === Some("Washington"))
  }

  test("country of capital") {
    assert(countryOfCapital === Map("Washington" -> "US", "Bern" -> "Switzerland"))
  }

  test("show capital of Andorra is missing data") {
    assert(showCapital("Andorra") === "missing data")
  }

  test("show capital of US is Washington") {
    assert(showCapital("US") === "Washington")
  }

  test("show <unknown> of Andorra") {
    assert(capital("Andorra") === "<unknown>")
  }

  test("sort fruit with length") {
    assert((fruit sortWith (_.length < _.length)) === List("pear", "apple", "orange", "pineapple"))
  }

  test("sort fruit by default") {
    assert(fruit.sorted === List("apple", "orange", "pear", "pineapple"))
  }

  test("groupBy fruit") {
    assert((fruit groupBy (_.head)) === Map('p' -> List("pear", "pineapple"), 'a' -> List("apple"), 'o' -> List("orange")))
  }

}

