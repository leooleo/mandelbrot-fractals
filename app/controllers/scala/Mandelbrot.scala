package scala
import java.awt.image.BufferedImage

class Mandelbrot extends Fractal{
  override def converges(c: ComplexNumber, maxIt: Int): Double = {
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
}