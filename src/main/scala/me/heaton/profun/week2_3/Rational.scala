package me.heaton.profun.week2_3

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  /*
   * Besides require, there is also assert.
   * Assert also takes a condition and an optional message string as parameters. E.g.
   *   val x = sqrt(y)
   *   assert(x >= 0)
   * Like require, a failing assert will also throw an exception, but it’s a different one: AssertionError for assert, IllegalArgumentException for require.
   * This reflects a difference in intent
   *   require is used to enforce a precondition on the caller of a function.
   *   assert is used as to check the code of the function itself.
   */

  /**
   * The primary constructor of the class is this(x, y)
   * Here is an auxiliary constructor
   */
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)

  /**
   * Numerator
   */
  def numer = x / g

  /**
   * Denominator
   */
  def denom = y / g

  def less(that: Rational) = this < that

  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this.less(that)) that else this

  def unary_- : Rational = new Rational(-numer, denom)

  def neg = -this

  def +(that: Rational) = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def add(that: Rational) = this + that

  def -(that: Rational) = this + -that

  def sub(that: Rational) = this - that

  def sub(that1: Rational, that2: Rational): Rational = this - that1 - that2

  def *(that: Rational) = new Rational(numer * that.numer, denom * that.denom)

  def mul(that: Rational) = this * that

  def /(that: Rational) = new Rational(numer * that.denom, denom * that.numer)

  def div(that: Rational) = this / that

  def ==(that: Rational) = numer * that.denom == denom * that.numer

  def equal(that: Rational) = this == that

  def result: Double = {
    numer * 1.0 / denom
  }

  override def toString: String = numer + "/" + denom
}
