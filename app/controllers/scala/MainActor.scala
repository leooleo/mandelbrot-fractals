package scala

import akka.actor.{Actor, ActorLogging, Props}
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.io.File

object MainActor {
  def props(width: Int, height: Int, center: ComplexNumber, c: ComplexNumber, scale: Double, iterations: Int, palette: Palette, julia: Boolean) =
    Props(new MainActor(width, height, center, c, scale, iterations, palette, julia))
}

class MainActor(width: Int, height: Int, center: ComplexNumber, c: ComplexNumber, scale: Double, iterations: Int, palette: Palette, julia: Boolean) extends Actor with ActorLogging {
  import GenerateActor._
  log.info(s"Generating mainActor")
  context.actorOf(GenerateActor.props(width, height, center, c, scale, iterations, palette, julia), "generate") ! Generate

  def receive = {
    case Generated(mImage) =>
      log.info("Saving image")
      ImageIO.write(mImage, "png", new File("public/images/result.png"))
      context.system.terminate()
  }
}