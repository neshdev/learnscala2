val xs = Stream.cons(1, Stream.cons(2, Stream.empty))

Stream(1,2,3)

(1 to 1000).toStream


def streamRange(lo: Int, hi: Int) :Stream[Int] = {
  if (lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

def listRannge(lo: Int, hi: Int) : List[Int] = {
  if ( lo >= hi) Nil
  else lo :: listRannge(lo+1, hi)
}

listRannge(1,10)
streamRange(1, 10)

//((1000 to 10000).toStream filter isPrime)(1)


//trait Stream[+A] extends Seq[A] {
//  def isEmpty: Boolean
//  def head : A
//  def tail: Stream[A]
//}
//
//object Stream {
//  def cons[T] =(hd: T, tl: => Stream[T]) = new Stream[T] {
//    def isEmpty = false
//    def head = hd
//    def tail = tl
//  }
//
//  val empty = new Stream[Nothing]{
//    def isEmpty = true
//    def head = throw new NoSuchElementException("empty.head")
//    def tail = throw new NoSuchElementException("empty.head")
//  }
//}

def streamRange1(lo: Int, hi: Int) : Stream[Int] = {
  print(lo + "")
  if (lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange1(lo+1,hi))
}

streamRange1(1,10).take(3)