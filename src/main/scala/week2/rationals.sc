class Rational(x: Int, y: Int) {

  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x,1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)


  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def neg: Rational = new Rational(-numer, denom)

  def plus(that: Rational) = new Rational(numer * that.numer, denom * that.denom)

  def sub(that: Rational) = add(that.neg)

  def less(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if (this.less(that)) that else this

  override def toString = numer + "/" + denom

  def + (that: Rational) = this.add(that)
  def < (that: Rational) = this.less(that)
  def - (that: Rational) = this.sub(that)
  def unary_- = neg

  def * (that: Rational) = this.plus(that)
}

val x = new Rational(1, 3)
x.numer
x.denom

val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.sub(y).sub(z)
x.less(y)
x.max(y)

//IllegalArgumentException:
// new Rational(1,0)

new Rational(2)

y.add(y)
y add y
y + y

x.less(y)
x < y

x.sub(y)
x - y

x.sub(y).sub(z)
x - y - z

x.neg
-x

val p = x.plus(y)
val p2 = x * y

x.plus(y).add(x).plus(y)
x * y + x * y //operadores tem precedência, como na matemática



















