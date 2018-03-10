package march2018.code

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Example3 extends App {

  case class FutOpt[A](value: Future[Option[A]]){

    def map[B](f : A => B): FutOpt[B] =
      FutOpt(value.map(_.map(f)))

    def flatMap[B](f: A => FutOpt[B]): FutOpt[B] =
      FutOpt(value.flatMap(optA =>optA match{
        case Some(a) => f(a).value
        case None => Future.successful(None)
      }))
  }

  val repository = new Repository

  val city = for{
    user <- FutOpt(repository.getUserOption(1))
    city <- FutOpt(repository.getAddressOption(user)).map(_.city)
  }yield city
  
  Thread.sleep(1000)
  println(s"result is ${city}")
}
