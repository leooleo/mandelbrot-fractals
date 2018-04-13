import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

class Mandelbrot {
  private val lg2 = math.log(2.0)
  private def log2(value: Double) = math.log(value) / lg2

  def converges(c: ComplexNumber, maxIt: Int): Double = {
    var z = ComplexNumber(0, 0)
    var it = 0

    while (z.absSquare <= 4.0 && it < maxIt) {
      z = z*z + c
      it += 1
    }

    if (it < maxIt) {
      (it - log2(log2(z.abs))) / maxIt
    }
    else {
      Double.PositiveInfinity
    }
  }

  def generate(width: Int, height: Int, palette: Palette): Unit = {
    val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val xRange :Range = Range(-1, -0.5)
    val yRange :Range = Range(-0.5625, -0.28125)

    for(y <- 0 until height){
      for(x <- 0 until width){
        val point :ComplexNumber = ComplexNumber(xRange.min + (xRange.dist * x.toDouble / width.toDouble),
                                     yRange.max - (yRange.dist * y.toDouble / height.toDouble))

        val i = converges(point, 1000)
        image.setRGB(x,y,palette(i).toRGB)
      }
    }
    ImageIO.write(image, "png", new File("output/mandelbrot.png"))

  }
}
