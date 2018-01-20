package feb2018.backup

/**
  * for {
  *   fResult <- f(2)
  *   gResult <- g(fResult)
  *   hResult <- h(gResult)
  * } yield hResult
  * */

case class Debuggable(result: Int, log: String) {
  def map(f: Int => Int): Debuggable = {
    Debuggable(f(this.result), s"input value $result")
  }

  def flatMap(f: Int => Debuggable): Debuggable = {
    val temp = f(this.result)
    Debuggable(temp.result, this.log + "  " + temp.log)
  }
}

object FPAlgebra4 extends App {

  def f(i : Int): Debuggable = {
    Debuggable(i * 2, s"f input value $i")
  }

  def g(j: Int): Debuggable = {
    Debuggable(j + 2, s"g input value $j")
  }

  def h(k: Int): Debuggable = {
    Debuggable(k + 1, s"h input value $k")
  }

  val result = for {
    fResult <- f(2)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println(s"Result ${ result.result }, logs: ${ result.log }")
}
