package scala
import java.awt.image.BufferedImage

abstract class Fractal {
  protected val lg2 = math.log(2.0)
  protected def log2(value: Double) = math.log(value) / lg2

  def converges(c: ComplexNumber, maxIt: Int) : Double

  def generate(width: Int, height: Int, center: ComplexNumber, scale: Double, palette: Palette): BufferedImage = {
    val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val ratio = width.toDouble / height.toDouble
    val xRange :RangeDouble = RangeDouble(center.real - scale, center.real + scale)
    val yRange :RangeDouble = RangeDouble(center.imaginary - (scale / ratio), center.imaginary + (scale / ratio));

    for(y <- 0 until height){
      for(x <- 0 until width){
        val point :ComplexNumber = ComplexNumber(xRange.min + (xRange.dist * x.toDouble / width.toDouble),
          yRange.max - (yRange.dist * y.toDouble / height.toDouble))

        val i = converges(point, 1000)
        image.setRGB(x,y,palette(i).toRGB)
      }
    }

    image
  }
}
