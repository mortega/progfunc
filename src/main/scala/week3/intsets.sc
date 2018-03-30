
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def union(other: IntSet): IntSet = {
    print(this + " this. ")
    print(other + " other. ")
    ((left union right) union other) incl elem
  }

  override def toString: String = "{" + left + elem + right + "}"
}

val set1 = new NonEmpty(2, new Empty, new Empty)

//Singleton
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}

//With singleton object
val set2 = new NonEmpty(2, Empty, Empty)
val set3 = set2 incl 4
val set4 = set3 incl 5

val set5 = new NonEmpty(1, Empty, Empty)
set4 union set5


