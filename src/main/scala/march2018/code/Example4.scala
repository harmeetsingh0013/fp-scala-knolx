package march2018.code

object Example4 extends App {
  case class ListOpt[A](value: List[Option[A]]){

    def map[B](f : A => B): ListOpt[B] =
      ListOpt(value.map(_.map(f)))

    def flatMap[B](f: A => ListOpt[B]): ListOpt[B] =
      ListOpt(value.flatMap(optA =>optA match{
        case Some(a) => f(a).value
        case None => List(None)
      }))
  }

  val repository = new Repository

  val city = for{
    user <- ListOpt(repository.getUsersOption)
    city <- ListOpt(repository.getAddressesOption(user)).map(_.city)
  }yield city

  Thread.sleep(1000)
  println(s"result is ${city}")

}
