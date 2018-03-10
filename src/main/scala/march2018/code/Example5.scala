package march2018.code

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Example5 extends App {

  case class WhateverOpt[M[_], A](value: M[Option[A]]) {

    def flatMap[B](f: A => WhateverOpt[M, B])(implicit M: Monad[M]): WhateverOpt[M, B] = {
      WhateverOpt(M.flatMap(value)(opt => opt match {
        case Some(a) => f(a).value
        case None => M.pure(None)
      }))
    }

    def map[B](f: A => B)(implicit M: Monad[M]): WhateverOpt[M, B] = {
      WhateverOpt(M.map(value)(_.map(f)))
    }
  }

  implicit val futureMonad = new Monad[Future] {
    override def pure[A](a: A): Future[A] = Future.successful(a)

    override def map[A, B](fa: Future[A])(f: A => B): Future[B] = fa.map(f)

    override def flatMap[A, B](fa: Future[A])(f: A => Future[B]): Future[B] = fa.flatMap(f)
  }

  val repository = new Repository

  val city: WhateverOpt[Future, String] = for{
    user <- WhateverOpt(repository.getUserOption(1))
    city <- WhateverOpt(repository.getAddressOption(user)).map(_.city)
  }yield city


  val value: Future[Option[String]] = city.value
  Thread.sleep(1000)
  println(s"result is ${city}")
}
