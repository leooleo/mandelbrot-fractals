

object Main {
  def call_fractals(): Unit = {
    val cantor_img = new drawing_module("output/cantor.png",(500,500))
    SimpleFractals.cantor(10, 20, 500-20,cantor_img)
    cantor_img.finnish()

    val circle_f1 = new drawing_module("output/circle_f1.png",(500,500))
    SimpleFractals.circle_fractal_1(250,250,250,circle_f1)
    circle_f1.finnish()

    val circle_f2 = new drawing_module("output/circle_f2.png",(500,500))
    SimpleFractals.circle_fractal_2(250,250,150,circle_f2)
    circle_f2.finnish()

    val circle_f3 = new drawing_module("output/circle_f3.png",(500,500))
    SimpleFractals.circle_fractal_3(683,384,190,circle_f3)
    circle_f3.finnish()
  }

  def colorConvert(value: Double) : CustomColor = {
    println((value))
    CustomColor((value * 255).toInt, (value * 255).toInt, (value * 255).toInt)
  }

  def main(args: Array[String]) {
    val m = new Mandelbrot()
    val j = new Julia()

    val palette = Palette(Array(
      (0.000, CustomColor(0.0, 0.0, 0.4)),
      (0.010, CustomColor(0.1, 0.1, 0.1)),
      (0.018, CustomColor(1.0, 1.0, 0.3)),
      (0.022, CustomColor(0.0, 0.4, 0.0)),
      (0.040, CustomColor(1.0, 1.0, 1.0)),
      (0.200, CustomColor(0.0, 0.0, 0.6)),
      (0.500, CustomColor(0.0, 0.0, 0.0)),
      (1.000, CustomColor(1.0, 1.0, 1.0)),
      (Double.PositiveInfinity, CustomColor.Black)
    ))

    m.generate(1920, 1080, palette, "output/m.png")
    j.generate(1920, 1080, palette, "output/j.png")
  }
}
