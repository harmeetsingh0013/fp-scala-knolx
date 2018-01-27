package feb2018.code

/**
  * val fResult = f(2)
  * val gResult = bind(g, fResult)
  * val hResult = bind(h, gResult)
  */
object FPAlgebra3 extends App {

  def f(i: Int): (Int, String) = {
    (i * 2, s"f input value of $i \n")
  }

  def g(j: Int): (Int, String) = {
    (j + 2, s"g input value of $j \n")
  }

  def h(k: Int): (Int, String) = {
    (k * 1, s"h input value of $k \n")
  }

  def bind(f: Int => (Int, String), result: (Int, String) ): (Int, String) = {
    val temp = f(result._1)
    (temp._1, result._2 + " " + temp._2)
  }

  val fResult = f(2)
  val gResult = bind(g, fResult)
  val hResult = bind(h, gResult)

  println(s" Result ${ hResult._1 } and logs: ${ hResult._2 }")
}
