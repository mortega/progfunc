def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 else f(a) * product(f)(a + 1, b)

product(x => x)(1,5)

def factorial(n: Int): Int = product(x => x)(1,n)
factorial(5)


def productInt(a: Int, b: Int): Int = product(x => x)(a,b)
productInt(1,5)

def factorialTest(n: Int): Int = productInt(1,n)
factorial(5)


def general(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if(a>b) zero
  else combine(f(a), general(f, combine, zero)(a+1, b))


def newP(f: Int => Int)(a: Int, b: Int): Int =
  general(f, (x,y) => x*y, 1)(a,b)
newP(x=>x)(1,5)

def newS(f: Int => Int)(a: Int, b: Int): Int =
  general(f, (x,y) => x+y, 0)(a,b)
newS(x=>x)(1,5)