package scala
case class Palette(colors: Array[CustomColor]) extends (Double => CustomColor) {

  def apply(value: Double): CustomColor = {
    if (value == Double.PositiveInfinity) {
      return CustomColor.Black
    }
    val total = colors.length
    val nd: Int = math.floor(value * total).toInt
    colors(nd)
  }
}

object Palette {
  val palette = Palette(Array(
    (CustomColor(1.0, 0.0, 0.0)), (CustomColor(1.0, 0.1, 0.0)),
    (CustomColor(1.0, 0.2, 0.0)), (CustomColor(1.0, 0.3, 0.0)),
    (CustomColor(1.0, 0.4, 0.0)), (CustomColor(1.0, 0.5, 0.0)),
    (CustomColor(1.0, 0.6, 0.0)), (CustomColor(1.0, 0.7, 0.0)),
    (CustomColor(1.0, 0.8, 0.0)), (CustomColor(1.0, 0.9, 0.0)),
    (CustomColor(0.9, 1.0, 0.0)), (CustomColor(0.8, 1.0, 0.0)),
    (CustomColor(0.7, 1.0, 0.0)), (CustomColor(0.6, 1.0, 0.0)),
    (CustomColor(0.5, 1.0, 0.0)), (CustomColor(0.4, 1.0, 0.0)),
    (CustomColor(0.3, 1.0, 0.0)), (CustomColor(0.2, 1.0, 0.0)),
    (CustomColor(0.1, 1.0, 0.0)), (CustomColor(0.0, 1.0, 0.0)),
    (CustomColor(0.0, 1.0, 0.1)), (CustomColor(0.0, 1.0, 0.2)),
    (CustomColor(0.0, 1.0, 0.3)), (CustomColor(0.0, 1.0, 0.4)),
    (CustomColor(0.0, 1.0, 0.5)), (CustomColor(0.0, 1.0, 0.6)),
    (CustomColor(0.0, 1.0, 0.7)), (CustomColor(0.0, 1.0, 0.8)),
    (CustomColor(0.0, 1.0, 0.9)), (CustomColor(0.0, 1.0, 1.0)),
    (CustomColor(0.0, 0.9, 1.0)), (CustomColor(0.0, 0.8, 1.0)),
    (CustomColor(0.0, 0.7, 1.0)), (CustomColor(0.0, 0.6, 1.0)),
    (CustomColor(0.0, 0.5, 1.0)), (CustomColor(0.0, 0.4, 1.0)),
    (CustomColor(0.0, 0.3, 1.0)), (CustomColor(0.0, 0.2, 1.0)),
    (CustomColor(0.0, 0.1, 1.0)), (CustomColor(0.0, 0.0, 1.0)),
    (CustomColor(0.1, 0.0, 1.0)), (CustomColor(0.2, 0.0, 1.0)),
    (CustomColor(0.3, 0.0, 1.0)), (CustomColor(0.4, 0.0, 1.0)),
    (CustomColor(0.5, 0.0, 1.0)), (CustomColor(0.6, 0.0, 1.0)),
    (CustomColor(0.7, 0.0, 1.0)), (CustomColor(0.8, 0.0, 1.0)),
    (CustomColor(0.9, 0.0, 1.0)), (CustomColor(1.0, 0.0, 1.0)),
    (CustomColor(1.0, 0.0, 0.9)), (CustomColor(1.0, 0.0, 0.8)),
    (CustomColor(1.0, 0.0, 0.7)), (CustomColor(1.0, 0.0, 0.6)),
    (CustomColor(1.0, 0.0, 0.5)), (CustomColor(1.0, 0.0, 0.4)),
    (CustomColor(1.0, 0.0, 0.3)), (CustomColor(1.0, 0.0, 0.2)),
    (CustomColor(1.0, 0.0, 0.1)), (CustomColor(1.0, 0.0, 0.0)),
    (CustomColor(0.9, 0.0, 0.0)), (CustomColor(0.8, 0.0, 0.0)),
    (CustomColor(0.7, 0.0, 0.0)), (CustomColor(0.6, 0.0, 0.0)),
    (CustomColor(0.5, 0.0, 0.0)), (CustomColor(0.4, 0.0, 0.0)),
    (CustomColor(0.3, 0.0, 0.0)), (CustomColor(0.2, 0.0, 0.0)),
    (CustomColor(0.1, 0.0, 0.0)), (CustomColor(0.0, 0.0, 0.0))
  ))
}