package feb2018.code

object WithFilterApp extends App {

  var flag = false
  List.range(1, 10).filter(_ % 2 == 1 && !flag)
      .foreach(i => if(i == 5) flag = true else println(s"Filter $i"))

  flag = false
  List.range(1, 10).withFilter(_ % 2 == 1 && !flag)
    .foreach(i => if(i == 5) flag = true else println(s"With Filter $i"))
}
