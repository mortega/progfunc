object list {

  trait List[T] {
    def isEmpty: Boolean

    def head: T

    def tail: List[T]
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
  }

  class Nil[T] extends List[T] {
    def isEmpty: Boolean = true

    def head: Nothing = throw new NoSuchElementException("Nil.head")

    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }

  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

  singleton[Int](1)
  singleton[Boolean](true)

  // Type inference
  singleton(1)
  singleton(true)


  def nth[T](n: Int, list: List[T]) = {

    def loop(acc: Int, list: List[T]): T =
      if (list.isEmpty) throw new IndexOutOfBoundsException
      else if (acc == n) list.head
      else loop(acc + 1, list.tail)

    loop(0, list)
  }

  nth(0, singleton(1))
  //nth(1, singleton(1))

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

  nth(0, list)
  nth(2, list)
  //nth(-1, list)
  //nth(4, list)

  /* Coursera */
  def nthC[T](n: Int, xs: List[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nthC(n - 1, xs.tail)
  }

  nthC(0, list)
  nthC(1, list)
  nthC(2, list)
  nthC(3, list)

}
