import java.awt.image.BufferedImage

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

  def generate(width: Int, height: Int, center: ComplexNumber, scale: Double, palette: Palette): BufferedImage = {
    val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val ratio = width.toDouble / height.toDouble
    val xRange :Range = Range(center.real - scale, center.real + scale)
    val yRange :Range = Range(center.imaginary - (scale / ratio), center.imaginary + (scale / ratio));

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