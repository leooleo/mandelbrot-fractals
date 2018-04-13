case class CustomColor(red: Double, green: Double, blue: Double) {
  def toRGB: Int = {
    def trim(i: Double) = {
      if (i > 1.0) 1.0
      else if (i < 0.0) 0.0
      else i
    }
    def toByte(i: Double) = math.round(255.0 * trim(i)).toInt

    toByte(red) << 16 | toByte(green) << 8 | toByte(blue)
  }
}

object CustomColor {
  val Black = CustomColor(0.0, 0.0, 0.0)

  def getIntermediaryColor(ff: CustomColor, ss: CustomColor, perc: Double) :CustomColor = {
    val red: Double = (Math.max(ff.red, ss.red) - Math.min(ff.red, ss.red)) * perc + Math.min(ff.red, ss.red)
    val green: Double = (Math.max(ff.green, ss.green) - Math.min(ff.green, ss.green)) * perc + Math.min(ff.green, ss.green)
    val blue: Double = (Math.max(ff.blue, ss.blue) - Math.min(ff.blue, ss.blue)) * perc + Math.min(ff.blue, ss.blue)

    CustomColor(red, green, blue)
  }
}
