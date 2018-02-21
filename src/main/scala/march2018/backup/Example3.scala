package march2018.backup

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Example3 extends App {

  val repository = new Repository

  case class FutOpt[A](value: Future[Option[A]]) {
    def map[B](f: A => B): FutOpt[B] =
      FutOpt(value.map(optA => optA.map(f)))

    def flatMap[B](f: A => FutOpt[B]): FutOpt[B] =
      FutOpt(value.flatMap(opt => opt match {
        case Some(a) => f(a).value
        case None => Future.successful(None)
      }))
  }

  val result = for {
    user <- FutOpt(repository.getUserOption(1))
    address <- FutOpt(repository.getAddressOption(user))
  } yield address.city

  Thread.sleep(1000)
  println(s"City: $result")

}
