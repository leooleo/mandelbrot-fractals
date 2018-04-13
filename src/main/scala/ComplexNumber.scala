case class ComplexNumber(real: Double, imaginary: Double) {
  def +(other: ComplexNumber) = ComplexNumber(real + other.real, imaginary + other.imaginary)

  def *(other: ComplexNumber) = ComplexNumber(real * other.real - imaginary * other.imaginary,
                                              real * other.imaginary + imaginary * other.real)

  def absSquare :Double = real * real + imaginary * imaginary
  def abs :Double = math.sqrt(absSquare)

}
