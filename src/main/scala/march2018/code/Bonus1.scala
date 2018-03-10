package march2018.code

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Bonus1 extends App {

  // side effects operations
  def getUserOption(id: Int): Future[Option[User]] =
    Future.successful(Some(User(13, "James")))

  def checkCanBeUpdated(u: User): Future[Boolean] =
    Future.successful(true)

  def updateUser(id:Int): Future[Option[User]]={
    getUserOption(id).flatMap{ userOpt =>
      userOpt match{
        case Some(user) => checkCanBeUpdated(user).flatMap{ canBeUpdated =>

          if(canBeUpdated)
            Future.successful(Some(user))
          else Future.successful(None)
        }

        case None => Future.successful(None)
      }
    }
  }

  val updatedUser = updateUser(1)
  Thread.sleep(1000)
  println(s" user is ${updatedUser}")

}
