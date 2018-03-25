def factorial(n: Int): Int =
  if(n == 0) 1 else n * factorial(n-1)

factorial(4)
factorial(5)


//Tail rescursion function :
// termina chamando uma função (ela mesma ou outra)
// usa o mesmo espaço para execução e evita stackoverflow

def factorialT(n: Int): Int = {
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n-1)

  loop(1, n)
}

factorialT(4)
factorialT(5)