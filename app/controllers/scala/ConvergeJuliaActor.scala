package scala

import akka.actor.{Actor, Props}

object ConvergeJuliaActor {
  def props(c: ComplexNumber, points: Vector[(Int, Int, Int, ComplexNumber)]) =
    Props(new ConvergeJuliaActor(c, points))

}

class ConvergeJuliaActor(c: ComplexNumber, points: Vector[(Int, Int, Int, ComplexNumber)]) extends Actor {
  import ConvergeActor._

  def receive = {
    case Converge =>
      var colors: Vector[(Int, Int, Double)] = Vector()
      for ((x, y, iterations, z) <- points) { 
        var it = 0
        var zz = z

        while (zz.absSquare <= 4.0 && it < iterations) {
          zz = zz*zz + c
          it += 1
        }

        if (it < iterations) {
          colors = colors :+ (x, y, it.toDouble / iterations.toDouble)
        }
        else {
          colors = colors :+ (x, y, Double.PositiveInfinity)
        }
      }
      sender ! Converges(colors)
  }
}