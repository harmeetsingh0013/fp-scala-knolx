package march2018.code

import scala.concurrent.ExecutionContext.Implicits.global

object Example1 extends App {

  val repository = new Repository

  val city = for {
    user <- repository.getUser(13)
    address <- repository.getAddress(user)
  } yield address.city

  Thread.sleep(1000)
  println(s"City: $city")
}
