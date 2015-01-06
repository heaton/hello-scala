package me.heaton.profun.week6

/**
 * the syntax key -> value is an alternative way to write the pair (key, value)
 */
object maps {

  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
  val countryOfCapital = capitalOfCountry map {case (x, y) => (y, x)}

  /**
   * Option Type
   * trait Option[+A]
   * case class Some[+A](value: A) extends Option[A]
   * object None extends Option[Nothing]
   */
  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(capital) => capital
    case None => "missing data"
  }

  val capital = capitalOfCountry withDefaultValue "<unknown>"

  val fruit = List("apple", "pear", "orange", "pineapple")

}
