package feb2018.backup

object FPAlgebra3 extends App {

  def f(i : Int): (Int, String) = {
    (i * 2, s"f input value $i")
  }

  def g(j: Int): (Int, String)  = {
    (j + 2, s"g input value $j")
  }

  def h(k: Int): (Int, String)  = {
    (k + 1, s"h input value $k")
  }

  def bind(f: Int => (Int, String), in: (Int, String)): (Int, String) = {
    val temp = f(in._1)
    (temp._1, in._2 + " " + temp._2)
  }

  val fResult = f(2)
  val gResult = bind(g, fResult)
  val hResult = bind(h, gResult)

  println(s"Result ${ hResult._1 }, logs: ${ hResult._2 }")
}
