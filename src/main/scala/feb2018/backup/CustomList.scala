package feb2018.backup

import scala.collection.mutable.ArrayBuffer

/**
  * generators List(2, 2, 3, 4, 5)
  * definitions i = somevalue
  * filters if(some condition)
  */
case class CustomList [A] (seq: A*) {

  private val list = new ArrayBuffer[A]
  list ++= seq

  def foreach(f: A => Unit): Unit = {
    list.foreach(f)
  }

  def map[B](f: A => B): CustomList[B] = {
    val temp = list.map(f)
    CustomList(temp: _*)
  }

  def withFilter(f: A => Boolean): CustomList[A] = {
    val temp = list.filter(f)
    CustomList(temp: _*)
  }

  def flatMap[B](f: A => CustomList[B]): CustomList[B] = {
    val temp = list.map(f)
    flatten(temp)
  }

  private def flatten[B](seq: Seq[CustomList[B]]): CustomList[B] = {
    val temp = new ArrayBuffer[B]

    for ( i <- seq) {
      for ( j <- i) {
        temp += j
      }
    }
    CustomList(temp: _*)
  }
}
