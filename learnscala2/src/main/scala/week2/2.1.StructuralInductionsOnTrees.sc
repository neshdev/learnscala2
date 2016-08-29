abstract class IntSet {
  def incl(x: Int) : IntSet
  def contains(x: Int) : Boolean
  def union(other: IntSet) : IntSet
}

case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int) =
    if (x < elem ) NonEmpty(elem, left incl x, right)
    else if (x > elem) NonEmpty(elem, left, right incl x )
    else this
  def contains(x: Int) =
    if ( x < elem) left.contains(x)
    else if (x > elem) right.contains(x)
    else true
  def union(other: IntSet) = (left union (right union other)) incl elem

}

object Empty extends IntSet {
  def contains(x: Int ) = false
  def incl(x :Int) = NonEmpty(x, Empty, Empty)
  def union(other: IntSet) = other
}