package scala

import java.awt.image.BufferedImage
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object GenerateActor {
  case object Generate
  case class Generated(image: BufferedImage)

  def props(width: Int, height: Int, center: ComplexNumber, c: ComplexNumber, scale: Double, iterations: Int, palette: Palette, julia: Boolean) =
    Props(new GenerateActor(width, height, center, c, scale, iterations, palette, julia))
}

class GenerateActor(width: Int, height: Int, center: ComplexNumber, c: ComplexNumber, scale: Double, iterations: Int, palette: Palette, julia: Boolean) extends Actor with ActorLogging {
  import ConvergeActor._
  import ConvergeJuliaActor._
  import GenerateActor._

  def receive = {
    case Generate =>
      log.info(s"Received Generate")
      val ratio = width.toDouble / height.toDouble
      val xRange :RangeDouble = RangeDouble(center.real - scale, center.real + scale)
      val yRange :RangeDouble = RangeDouble(center.imaginary - (scale / ratio), center.imaginary + (scale / ratio))
      val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
      val total = width*height

      context.become(generating(image, 8, sender))
      
      log.info(s"Calling Converge for each point")
      var max: Int = total / 8
      var current: Int = 0
      var points: Vector[(Int, Int, Int, ComplexNumber)] = Vector()
      for(y <- 0 until height){
        for(x <- 0 until width){
          val point :ComplexNumber = ComplexNumber(xRange.min + (xRange.dist * x.toDouble / width.toDouble),
            yRange.max - (yRange.dist * y.toDouble / height.toDouble))

          points = points :+ (x, y, iterations, point)

          current = current + 1
          if (current >= max) {
            if (!julia) context.actorOf(ConvergeActor.props(points)) ! Converge
            else context.actorOf(ConvergeJuliaActor.props(c, points)) ! Converge
            points = Vector()
            current = 0
          }
        }
      }
      log.info(s"Called Converge for each point")
  }

  def generating(image: BufferedImage, total: Int, receiver: ActorRef): Receive = {
    case Converges(result) =>
      log.info(s"Faltam $total atores")
      context.stop(sender)
      result foreach { case (x, y, i) => image.setRGB(x, y, palette(i).toRGB) }
      if (total > 1) context.become(generating(image, total-1, receiver))
      else receiver ! Generated(image)
  }
}