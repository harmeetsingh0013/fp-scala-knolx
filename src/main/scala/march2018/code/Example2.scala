package march2018.code

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Example2 extends App {

  val repository = new Repository

  /*val city = for {
    userOpt <- repository.getUserOption(13)
    user <- userOpt
    addressOpt <- repository.getAddressOption(user)
    address <- addressOpt
  } yield address.city*/

  /* val city = repository.getUserOption(13).flatMap{ userOpt =>
    userOpt.flatMap{ user =>}
  }
}*/

  //def flatMap[A, B](f: A => Future[B]): Future[B] = ???

  val city = for {
    userOpt <- repository.getUserOption(13)
    city <- userOpt match {
      case Some(user) => repository.getAddressOption(user).map(_.map(_.city))
      case None => Future.successful(None)
    }

  } yield city


  Thread.sleep(1000)
  println(s"city is ${city}")
}
