package feb2018.code

/**
  * for {
  *   fResult <- f(2)
  *   gResult <- g(fResult)
  *   hResult <- h(gResult)
  * } yield hResult
  */

case class Debuggable(value: Int, log: String) {

  def map(f: Int => Int): Debuggable = {
    Debuggable(this.value, this.log)
  }

  def flatMap(f: Int => Debuggable): Debuggable = {
    val temp = f(this.value)
    Debuggable(temp.value, log+ " " + temp.log)
  }
}

object FPAlgebra4 extends App {

  def f(i: Int): Debuggable = {
    Debuggable(i * 2, s"f input value of $i \n")
  }

  def g(j: Int): Debuggable = {
    Debuggable(j + 2, s"g input value of $j \n")
  }

  def h(k: Int): Debuggable = {
    Debuggable(k * 1, s"h input value of $k \n")
  }

  val result = for {
    fResult <- f(2)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println(s" Result ${ result.value } and logs: ${ result.log }")
}
