package scala
import java.io.File
import javax.imageio.ImageIO

object Main {

  def call_cantor() : Unit = {
    val cantor_img = new drawing_module("public/images/cantor.png",(1280,720))
    SimpleFractals.cantor(10, 20, 500-20,cantor_img)
    cantor_img.finnish()
  }

  def call_circle_1() : Unit ={
    val circle_f1 = new drawing_module("public/images/circle_f1.png",(1280,720))
    SimpleFractals.circle_fractal_1(250,250,250,circle_f1)
    circle_f1.finnish()
  }
  def call_circle_2() : Unit = {
    val circle_f2 = new drawing_module("public/images/circle_f2.png",(1280,720))
    SimpleFractals.circle_fractal_2(250,250,150,circle_f2)
    circle_f2.finnish()
  }
  def call_circle_3() : Unit = {
    val circle_f3 = new drawing_module("public/images/circle_f3.png",(1280,720))
    SimpleFractals.circle_fractal_3(683,384,190,circle_f3)
    circle_f3.finnish()
  }

  def colorConvert(value: Double) : CustomColor = {
    println((value))
    CustomColor((value * 255).toInt, (value * 255).toInt, (value * 255).toInt)
  }
}