

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
  def main(args: Array[String]) {
    val m = new Mandelbrot(1920,1080,1000)
  }
}
