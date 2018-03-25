
//sum is now a function that returns another function.
def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)

sumInts(1,5)
sumCubes(1,5)

//Or:
def cube(x: Int): Int = x * x * x
sum(cube)(1,5)

//sum(cube) is equivalent to sumCubes.

//Short way for returning a function:

def shortSum(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + shortSum(f)(a + 1, b)

def sSumInts(a: Int, b: Int): Int = shortSum(x => x)(a,b)
def sSumCubes(a: Int, b: Int): Int = shortSum(x => x * x * x)(a,b)

sSumInts(1,5)
sSumCubes(1,5)




