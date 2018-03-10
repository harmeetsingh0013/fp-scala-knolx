package march2018.code

import cats.data.OptionT
import cats.instances.future._

import scala.concurrent.ExecutionContext.Implicits.global

object Example7 extends App {
  val repository = new Repository

  val firstName = for {
    user: User <- OptionT(repository.getUserOption(13))
    age <- OptionT.liftF(repository.getUserAgeByName(user.name))
    firstName <- OptionT.fromOption(repository.getUserFirstName(user.id))
  } yield firstName

  Thread.sleep(1000)
  println(s"result is ${firstName}")
}
