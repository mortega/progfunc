def abs(x:Double) = if (x < 0) -x else x

def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)

def isGoodEnough(guess: Double, x: Double) =
  abs(guess * guess - x) < 0.001

def improve(guess: Double, x: Double) =(guess + x / guess) / 2

def sqrt(x: Double) = sqrtIter(1.0, x)

sqrt(2)
sqrt(4)
sqrt(1e-6) //impreciso. Resp = 0.001
sqrt(1e-20) //Resp = 1e-10
sqrt(1.0e20)
// sqrt(1e60) -- não termina

// isGoodEnough não é preciso para números pequenos
// e pode não terminar para números maiores
// Criar outra versão e testar:
// 0.001 0.1e-20 1.0e20 1.0e50

def approximation(x: Double) = if(x>1) 0.0001 else x/10

def initialGuess(x: Double) =  1 + x/10

def newIsGoodEnough(guess: Double, x: Double) =
  abs(guess * guess - x) / x < 0.001

def newSqrtIter(guess: Double, x: Double): Double =
  if (newIsGoodEnough(guess, x)) guess
  else newSqrtIter(improve(guess, x), x)

def newSqrt(x: Double) = newSqrtIter(1, x)

newSqrt(2)
newSqrt(4)
newSqrt(9)
newSqrt(1.0e-6)
newSqrt(1.0e-20)
newSqrt(1.0e20)
newSqrt(1e60)
