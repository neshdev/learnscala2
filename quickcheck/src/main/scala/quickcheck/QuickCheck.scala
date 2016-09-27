package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

//  lazy val genHeap: Gen[H] = for {
//    x <- arbitrary[A]
//    h <- oneOf(Gen.const(empty), genHeap)
//  } yield insert(x, h)

  lazy val genHeap: Gen[H] = for {
    n <- arbitrary[A]
    h <- frequency((1, Gen.const(empty)), (9, genHeap))
  } yield insert(n, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("hint1") = forAll { (n1:A, n2: A) =>
    val h = insert(n1, insert(n2,empty))
    findMin(h) == Math.min(n1,n2)
  }

  property("hint2") = forAll { (n1:A) =>
    val h = insert(n1, empty)
    deleteMin(h) == empty
  }

  property("hint3") = forAll{ (h: H) =>
    def heapSort(h1: H ) : List[A] = {
      if (isEmpty(h1)) Nil
      else findMin(h1) :: heapSort(deleteMin(h1))
    }
    val results = heapSort(h)
    results == results.sorted
  }

  property("hint4") = forAll{ (h1: H, h2:H) =>
    val minH1 = findMin(h1)
    val minH2 = findMin(h2)
    val m = meld(h1,h2)
    findMin(m) == Math.min(minH1,minH2)
  }

  property("meld") = forAll { (h1: H, h2: H) =>
    def heapEqual(h1: H, h2: H): Boolean =
      if (isEmpty(h1) && isEmpty(h2)) true
      else {
        val m1 = findMin(h1)
        val m2 = findMin(h2)
        m1 == m2 && heapEqual(deleteMin(h1), deleteMin(h2))
      }
    heapEqual(meld(h1, h2),
      meld(deleteMin(h1), insert(findMin(h1), h2)))
  }


  property("nw1") = forAll { (h1: H, h2: H) =>
    val m1 = findMin(h1)
    val m2 = findMin(h2)
    val min = m1.min(m2)
    findMin(meld(deleteMin(h1),insert(min,h2)))==min
  }
}
