import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

class Mandelbrot {
  protected val lg2 = math.log(2.0)
  protected def log2(value: Double) = math.log(value) / lg2

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

  def generate(width: Int, height: Int, palette: Palette, name: String): Unit = {
    val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val xRange :Range = Range(-2, 2)
    val yRange :Range = Range(-1, 1)



    for(y <- 0 until height){
      for(x <- 0 until width){
        val point :ComplexNumber = ComplexNumber(xRange.min + (xRange.dist * x.toDouble / width.toDouble),
          yRange.max - (yRange.dist * y.toDouble / height.toDouble))

        val i = converges(point, 1000)
        image.setRGB(x,y,palette(i).toRGB)
      }
    }
    ImageIO.write(image, "png", new File(name))

  }
}

class Julia extends Mandelbrot {
  override def converges(z: ComplexNumber, maxIt: Int): Double = {
    var c = ComplexNumber(0.45, 0.1428)
    var zz = z
    var it = 0

    while (zz.absSquare <= 4.0 && it < maxIt) {
      zz = zz * zz + c
      it += 1
    }
    if (it < maxIt) {
      (it - log2(log2(z.abs))) / maxIt
    }
    else {
      Double.PositiveInfinity
    }
  }
}