package feb2018.code

object FPAlgebra1 extends App {

  def f(i: Int): Int = {
    println(s"f input value of $i")
    i * 2
  }

  def g(j: Int): Int = {
    println(s"g input value of $j")
    j + 2
  }

  def h(k: Int): Int = {
    println(s"h input value of $k")
    k * 1
  }

  val result = h(g(f(2)))
  println(s"Result $result")
}
