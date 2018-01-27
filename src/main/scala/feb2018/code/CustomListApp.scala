package feb2018.code

object CustomListApp extends App {

  val customList = CustomList(1, 2, 3, 4, 5)
  for( i <- customList ) {
    println(i)
  }

  val result: CustomList[Int] = for {
    i <- customList
  } yield i * 2

  println(s"Result: $result")

  val result1: CustomList[Int] = for {
    i <- customList
    if(i % 2 == 0)
  } yield i

  println(s"Result1: $result1")

  val result2: CustomList[Int] = for {
    i <- customList
    j <- customList
    k <- customList
  } yield i + j + k

  println(s"Result2: $result2")

  val result3 = customList.flatMap { i =>
    customList.flatMap { j =>
      customList.map { k =>
        i + j + k
      }
    }
  }

  println(s"Result3: $result3")
}
