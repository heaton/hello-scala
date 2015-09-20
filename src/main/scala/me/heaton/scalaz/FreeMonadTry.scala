package me.heaton.scalaz

import scalaz._

/**
 * The free monad is just the combination of monads and interpreters.
 * The basics of the free monad:
 * - it’s something we can wrap around an arbitrary type constructor (a F[_]) to construct a monad.
 */
object FreeMonadTry {

  type UserId = Int
  type UserName = String

  type Requestable[A] = Coyoneda[Request, A]

  final case class User(id: UserId, name: UserName)

  sealed trait Request[A]
  final case class Pure[A](a: A) extends Request[A]
  final case class FetchUser(userId: UserId) extends Request[User]

  object Request {
    def pure[A](a: A): Free[Requestable, A] = Free.liftFC(Pure(a))
    def fetchUser(userId: UserId): Free[Requestable, User] = Free.liftFC(FetchUser(userId))
  }

  object ToyInterpreter extends (Request ~> Id.Id) {
    import Id._

    def apply[A](in: Request[A]): Id[A] = in match {
      case Pure(a) => a
      case FetchUser(userId) => User(1, "Heaton")
    }
  }

  object Example {

    import Request._

    val free: Free[Requestable, User] = for {
      user <- fetchUser(1)
    } yield user

    def run: User = Free.runFC(free)(ToyInterpreter)
  }

  def main(args: Array[String]) {
    println(Example.run)
  }

}
