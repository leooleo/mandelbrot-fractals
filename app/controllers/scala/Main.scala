package scala
import java.io.File
import javax.imageio.ImageIO

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

    val mImage = m.generate(1280, 720, 1000, ComplexNumber(-1.02100, 0.27010), 0.00001225, palette) 
    //val jImage = j.generate(1280, 720, ComplexNumber(0, 0), 2, palette)
    ImageIO.write(mImage, "png", new File("public/images/m.png"))
    //ImageIO.write(jImage, "png", new File("output/j.png"))
  }
}
