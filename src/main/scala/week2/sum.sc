// Soma de inteiros de um intervalo
def sumInts(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts(a + 1, b)

sumInts(1,5)

// Soma do cubo dos inteiros de um intervalo
def cube(x: Int): Int = x * x * x
def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

sumCubes(1,5)

/*  High order function:
Functions that take other functions as parameters or that return
functions as results */
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)

def id(x: Int): Int = x

def newSumInts(a: Int, b: Int) = sum(id, a, b)
def newSumCubes(a: Int, b: Int) = sum(cube, a, b)

newSumInts(1,5)
newSumCubes(1,5)

// Using anonymus functions:
def aSumInts(a: Int, b: Int) = sum(x => x, a, b)
def aSumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

aSumInts(1,5)
aSumCubes(1,5)


//Tail recursive versiong of sum:
def tailRecursiveSum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a>b) acc
    else loop(a+1, f(a) + acc)
  }
  loop(a, 0)
}

def finalSumInts(a: Int, b: Int) = tailRecursiveSum(x => x, a, b)
def finalSumCubs(a: Int, b: Int) = tailRecursiveSum(x => x*x*x, a, b)

finalSumInts(1,5)
finalSumCubs(1,5)