trait M[T] {
  //flatmap commonly called as bind
  def flatMap[U](f :T => M[U]) : M[U]
}

def unit[T](x:T) : M[T]

//Examples of a Monads
//unix(x) = List(x)
//unit(x) = Set(x)
//unix(x) = Some(x)
//Generator for a unit(x) = single(x)

//map can be defined for every monad as a combincation
//m map f == m flatMap (x => unit(f(x)))
//        == m flatMap (f andThen unit)

//Monad Laws -> Monoid
//  1. Associativity
// (m flatMap f) flatMap g == m flatMap ((x=> f(x) flatMap g))
//   (x + y) + z = x + (y + z)
//  2. Left Unit
// unit(x) flatMap f == f(x)
//  3. Right Unit
// m flatMap unit == m

//#checking monad laws
//abstract class Option[+T] {
//  def flatMap[U](f: T => Option[U]) : Option[U] = this match  {
//    case Some(x) => f(x)
//    case None => None
//  }
//}