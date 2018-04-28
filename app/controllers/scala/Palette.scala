package scala
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

object Palette {
  val palette = Palette(Array(
    (0.00000000000, CustomColor(1.0, 0.0, 0.0)), (0.01428571428, CustomColor(1.0, 0.1, 0.0)),
    (0.02857142856, CustomColor(1.0, 0.2, 0.0)), (0.04285714284, CustomColor(1.0, 0.3, 0.0)),
    (0.05714285712, CustomColor(1.0, 0.4, 0.0)), (0.0714285714, CustomColor(1.0, 0.5, 0.0)),
    (0.08571428568, CustomColor(1.0, 0.6, 0.0)), (0.09999999996, CustomColor(1.0, 0.7, 0.0)),
    (0.11428571424, CustomColor(1.0, 0.8, 0.0)), (0.12857142852, CustomColor(1.0, 0.9, 0.0)),
    (0.1428571428, CustomColor(0.9, 1.0, 0.0)), (0.15714285708, CustomColor(0.8, 1.0, 0.0)),
    (0.17142857136, CustomColor(0.7, 1.0, 0.0)), (0.18571428564, CustomColor(0.6, 1.0, 0.0)),
    (0.19999999992, CustomColor(0.5, 1.0, 0.0)), (0.2142857142, CustomColor(0.4, 1.0, 0.0)),
    (0.22857142848, CustomColor(0.3, 1.0, 0.0)), (0.24285714276, CustomColor(0.2, 1.0, 0.0)),
    (0.25714285704, CustomColor(0.1, 1.0, 0.0)), (0.27142857132, CustomColor(0.0, 1.0, 0.0)),
    (0.2857142856, CustomColor(0.0, 1.0, 0.1)), (0.29999999988, CustomColor(0.0, 1.0, 0.2)),
    (0.31428571416, CustomColor(0.0, 1.0, 0.3)), (0.32857142844, CustomColor(0.0, 1.0, 0.4)),
    (0.34285714272, CustomColor(0.0, 1.0, 0.5)), (0.357142857, CustomColor(0.0, 1.0, 0.6)),
    (0.37142857128, CustomColor(0.0, 1.0, 0.7)), (0.38571428556, CustomColor(0.0, 1.0, 0.8)),
    (0.39999999984, CustomColor(0.0, 1.0, 0.9)), (0.41428571412, CustomColor(0.0, 1.0, 1.0)),
    (0.4285714284, CustomColor(0.0, 0.9, 1.0)), (0.44285714268, CustomColor(0.0, 0.8, 1.0)),
    (0.45714285696, CustomColor(0.0, 0.7, 1.0)), (0.47142857124, CustomColor(0.0, 0.6, 1.0)),
    (0.48571428552, CustomColor(0.0, 0.5, 1.0)), (0.4999999998, CustomColor(0.0, 0.4, 1.0)),
    (0.51428571408, CustomColor(0.0, 0.3, 1.0)), (0.52857142836, CustomColor(0.0, 0.2, 1.0)),
    (0.54285714264, CustomColor(0.0, 0.1, 1.0)), (0.55714285692, CustomColor(0.0, 0.0, 1.0)),
    (0.5714285712, CustomColor(0.1, 0.0, 1.0)), (0.58571428548, CustomColor(0.2, 0.0, 1.0)),
    (0.59999999976, CustomColor(0.3, 0.0, 1.0)), (0.61428571404, CustomColor(0.4, 0.0, 1.0)),
    (0.62857142832, CustomColor(0.5, 0.0, 1.0)), (0.6428571426, CustomColor(0.6, 0.0, 1.0)),
    (0.65714285688, CustomColor(0.7, 0.0, 1.0)), (0.67142857116, CustomColor(0.8, 0.0, 1.0)),
    (0.68571428544, CustomColor(0.9, 0.0, 1.0)), (0.69999999972, CustomColor(1.0, 0.0, 1.0)),
    (0.714285714, CustomColor(1.0, 0.0, 0.9)), (0.72857142828, CustomColor(1.0, 0.0, 0.8)),
    (0.74285714256, CustomColor(1.0, 0.0, 0.7)), (0.75714285684, CustomColor(1.0, 0.0, 0.6)),
    (0.77142857112, CustomColor(1.0, 0.0, 0.5)), (0.7857142854, CustomColor(1.0, 0.0, 0.4)),
    (0.79999999968, CustomColor(1.0, 0.0, 0.3)), (0.81428571396, CustomColor(1.0, 0.0, 0.2)),
    (0.82857142824, CustomColor(1.0, 0.0, 0.1)), (0.84285714252, CustomColor(1.0, 0.0, 0.0)),
    (0.8571428568, CustomColor(0.9, 0.0, 0.0)), (0.87142857108, CustomColor(0.8, 0.0, 0.0)),
    (0.88571428536, CustomColor(0.7, 0.0, 0.0)), (0.89999999964, CustomColor(0.6, 0.0, 0.0)),
    (0.91428571392, CustomColor(0.5, 0.0, 0.0)), (0.9285714282, CustomColor(0.4, 0.0, 0.0)),
    (0.94285714248, CustomColor(0.3, 0.0, 0.0)), (0.95714285676, CustomColor(0.2, 0.0, 0.0)),
    (0.97142857104, CustomColor(0.1, 0.0, 0.0)), (0.98571428532, CustomColor(0.0, 0.0, 0.0)),
    (Double.PositiveInfinity, CustomColor.Black)
  ))
}