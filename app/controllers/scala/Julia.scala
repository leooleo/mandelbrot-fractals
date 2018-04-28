package scala

class Julia (c: ComplexNumber) extends MandelbrotJuliaBase {
  override def converges(z: ComplexNumber, maxIt: Int): Double = {
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
