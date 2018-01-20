package feb2018.backup

object CustomListApp extends App {

  val custList = CustomList(1, 2, 3, 4, 5)

  for (i <- custList) {
    println(i)
  }

  val result1: CustomList[Int] = for (i <- custList ) yield (i * 2)
  println(s" Result 2: $result1")

  val result2 = for  {
    i <- custList
    j = i * 2
    if (j % 2 == 0)
  } yield j
  println(s" Result 2: $result2")

  val result3 = for {
    i <- custList
    j <- custList
    k <- custList
  } yield i + j + k

  println(s" Result 3: $result3")
}
