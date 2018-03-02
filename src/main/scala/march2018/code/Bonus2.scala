package march2018.code

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Bonus2 extends App {

  case class MyError(msg: String)

  // side effects operations
  def getUserOption(id: Int): Future[Option[User]] =
    Future.successful(Some(User(13, "James")))

  def checkCanBeUpdated(u: User): Future[Boolean] =
    Future.successful(true)

  
}
