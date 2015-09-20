package me.heaton.scalaz

object FunctorTry {

  trait Functor[F[_]] {
    def map[A, B](a: F[A])(f: A => B): F[B]
  }

  def listFunctor = new Functor[List] {
    def map[A, B](a: List[A])(f: A => B) = a.map(f)
  }

}
