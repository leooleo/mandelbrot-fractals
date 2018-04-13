case class Palette(colors: Array[(Double, CustomColor)]) extends (Double => CustomColor) {

  def apply(value: Double): CustomColor = {
    val (before, after) = colors span { _._1 <= value }
    if (before.isEmpty) after.head._2
    else if (after.isEmpty) before.last._2
    else {
      val colorDist = after.head._1 - before.last._1
      val valueVal = value - before.last._1
      val perc = valueVal / colorDist

      CustomColor.getIntermediaryColor(before.last._2, after.head._2, perc)
    }
  }
}