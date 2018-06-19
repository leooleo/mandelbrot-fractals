package scala

import akka.actor.{Actor, Props}

object ConvergeActor {
  case object Converge
  case class Converges(colors: Vector[(Int, Int, Double)])

  def props(points: Vector[(Int, Int, Int, ComplexNumber)]) =
    Props(new ConvergeActor(points))

}

class ConvergeActor(points: Vector[(Int, Int, Int, ComplexNumber)]) extends Actor {
  import ConvergeActor._

  def receive = {
    case Converge =>
      var colors: Vector[(Int, Int, Double)] = Vector()
      for ((x, y, iterations, c) <- points) { 
        var it = 0
        var zz = ComplexNumber(0, 0)

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