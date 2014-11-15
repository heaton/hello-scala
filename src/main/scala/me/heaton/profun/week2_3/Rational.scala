package me.heaton.profun.week2_3

class Rational(x: Int, y: Int) {

  /**
   * Numerator
   */
  def numer = x

  /**
   * Denominator
   */
  def denom = y

  def neg = new Rational(-numer, denom)

  def add(that: Rational) = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def sub(that: Rational) = add(that.neg)

  def sub(that1: Rational, that2: Rational): Rational = sub(that1).sub(that2)

  def mul(that: Rational) = new Rational(numer * that.numer, denom * that.denom)

  def div(that: Rational) = new Rational(numer * that.denom, denom * that.numer)

  def equal(that: Rational) = numer * that.denom == denom * that.numer

  def result: Double = {
    numer * 1.0 / denom
  }

  override def toString: String = numer + "/" + denom
}
