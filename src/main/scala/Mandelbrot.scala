import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

class Mandelbrot(width: Int, height: Int, max_iterations: Int) {
  val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
  // Palette of colors
  val palette = new Array[Int](max_iterations+1)
  // Initial values of mandelbrot
  val xMin: Double = -2.0
  val xMax: Double =  1.0
  val yMin: Double = -1.0
  val yMax: Double =  1.0

  initialize()

  def initialize(): Unit = {
    for ( i <- 0 to max_iterations) {
      // Initialize palette colors
      palette(i) = Color.HSBtoRGB(i / 256f, 1, i / (i + 8f))
    }
    main_loop()
  }

  def is_mandelbrot(x0: Double, y0: Double): Int ={
    var x :Double = 0
    var y :Double = 0
    var iteration = 0

    while( x*x + y*y < 4 && iteration < max_iterations){
      x = x*x - y*y + x0
      y = 2*x*y + y0
      iteration += 1
    }
    iteration
  }

  def main_loop(): Unit ={
    for(y <- 0 until height){
      for(x <- 0 until width){
        // Map real number(scaled x coordinate of pixel)
        val cr: Double = x * ((xMax-xMin)/width) + xMin
        // Map imaginary number(scaled y coordinate of pixel)
        val ci: Double = y * ((yMax-yMin)/height) + yMin
        val i = is_mandelbrot(cr,ci)
        // Set color
        val color = palette(i)
        if (i < max_iterations){
          image.setRGB(x,y,color)
        }
        else {
          image.setRGB(x, y, 0)
        }
      }
    }
    ImageIO.write(image, "png", new File("output/mandelbrot.png"))
  }

}
