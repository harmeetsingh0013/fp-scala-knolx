package feb2018.backup

object WithFilterApp extends App {

  var found = false
  List.range(1, 10).filter(_ % 2 == 1 && !found)
      .foreach(x => if (x == 5) found = true else println(s" Filter $x"))

  found = false
  List.range(1, 10).withFilter(_ % 2 == 1 && !found)
      .foreach(x => if (x == 5) found = true else println(s"With Filter: $x"))
}
