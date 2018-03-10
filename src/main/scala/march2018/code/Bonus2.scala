package march2018.code

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Bonus2 extends App {

  case class MyError(msg: String)

  // side effects operations
  def getUserOption(id: Int): Future[Option[User]] =
    Future.successful(Some(User(13, "James")))

  def checkCanBeUpdated(u: User): Future[Boolean] =
    Future.successful(false)

  def updateUser(id:Int): Future[Either[MyError,User]]={
    getUserOption(id).flatMap{ userOpt =>
      userOpt match{
        case Some(user) => checkCanBeUpdated(user).flatMap{ canBeUpdated =>

          if(canBeUpdated)
            Future.successful(Right(user))
          else Future.successful(Left(MyError("can not update the user!!")))
        }

        case None => Future.successful(Left(MyError("No user found!!")))
      }
    }
  }

  val updatedUser = updateUser(1)
  Thread.sleep(1000)
  println(s" user is ${updatedUser}")

  
}
