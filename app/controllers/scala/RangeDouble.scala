package scala
case class RangeDouble(min: Double, max: Double) {
  def dist:Double = max - min
}