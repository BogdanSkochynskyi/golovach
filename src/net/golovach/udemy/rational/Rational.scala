package net.golovach.udemy.rational

/**
 * 1/3+1/2 = 2/6+3/6
 * 1/3*1/2 = 2/6
 * 1/3 / 1/2 = 1/3*2/1
 *
 * @param n - numerator
 * @param d - denominator
 */

class Rational (n: Int, d: Int){

  def this(n: Int) = this(n, 1) //auxiliary constructor

  require(d != 0)

  private val g = gcd(n.abs, d.abs) //absolute value
  val numer: Int = n / g
  val denom: Int = d / g

  override def toString = numer + "/" + denom

  def +(second: Rational): Rational =
    new Rational(numer*second.denom + second.numer*denom, denom*second.denom)

  def +(second: Int): Rational =
    new Rational(numer + second * denom, denom)

  def -(second: Rational): Rational =
    new Rational(numer*second.denom - second.numer*denom, denom * second.denom)

  def -(second: Int): Rational =
    new Rational(numer - second * denom, denom)

  def *(second: Rational): Rational =
    new Rational(numer * second.numer, denom * second.denom)

  def *(second: Int): Rational =
    new Rational(numer * second, denom)

  def /(second: Rational): Rational =
    new Rational(numer * second.denom, denom * second.numer)

  def /(second: Int): Rational =
    new Rational(numer, denom * second)

  def lessThan(second: Rational) =
    this.numer * second.denom < second.numer * this.denom // here we can not use this

  def max(second: Rational) =
    if (this.lessThan(second)) second else this  //here we must use this

  println("Created: " + this.toString)

  private def gcd(a: Int, b: Int): Int =
    if (b==0) a else gcd(b, a % b)
}

object Demo{
  def main (args: Array[String]) {
    implicit def intToRational(x: Int) = new Rational(x)
    val a = new Rational(1,2)
    val b = new Rational(2,3)
    val c = 2 + b
    println("c = " + c)
    println(a * b)
    println(a.max(b))
  }
}
