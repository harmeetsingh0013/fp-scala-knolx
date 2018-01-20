package feb2018.backup

object FPAlgebra1 extends App {

  def f(i : Int): Int = {
    println(s"f input value $i")
    i * 2
  }

  def g(j: Int): Int = {
    println(s"g input value $j")
    j + 2
  }

  def h(k: Int): Int = {
    println(s"h input value $k")
    k + 1
  }

  val result = h(g(f(2)))
  println(s"Result is $result")
}
