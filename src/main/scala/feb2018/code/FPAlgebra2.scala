package feb2018.code

object FPAlgebra2 extends App {

  def f(i: Int): (Int, String) = {
    (i * 2, s"f input value of $i \n")
  }

  def g(j: Int): (Int, String) = {
    (j + 2, s"g input value of $j \n")
  }

  def h(k: Int): (Int, String) = {
    (k * 1, s"h input value of $k \n")
  }

  val fResult = f(2)
  val gResult = g(fResult._1)
  val hResult = h(gResult._1)

  val log = fResult._2 + " " + gResult._2 + " " + hResult._2

  println(s" Result ${ hResult._1 } and logs: $log")
}
