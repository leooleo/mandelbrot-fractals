package scala
import java.awt.geom.{Ellipse2D, Line2D}
import java.awt.image.BufferedImage
import java.awt.{BasicStroke, Color, Graphics2D}

class drawing_module (val file_name: String,val size: (Int,Int)){
  // Param = file name and width,height of canvas
  val canvas = new BufferedImage(size._1, size._2, BufferedImage.TYPE_INT_RGB)
  val g: Graphics2D = canvas.createGraphics()

  initialize()
  def initialize(): Unit ={
    // clear background
    g.setColor(Color.WHITE)
    g.fillRect(0, 0, canvas.getWidth, canvas.getHeight)

    // enable anti-aliased rendering (prettier lines and circles)
    // Comment it out to see what this does!
    g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
      java.awt.RenderingHints.VALUE_ANTIALIAS_ON)
  }
  def draw_line(x1 :Float ,y1 :Float,x2 :Float,y2 :Float): Unit = {
    g.setStroke(new BasicStroke())  // reset to default
    g.setColor(Color.BLACK) // same as Color.BLUE
    g.draw(new Line2D.Double(x1,y1,x2,y2))
  }

  def draw_circle(x: Double,y: Double, radius: Double): Unit ={
    g.setStroke(new BasicStroke())  // reset to default
    g.setColor(Color.BLACK)
    g.draw(new Ellipse2D.Double(x-radius,y-radius,2*radius,2*radius))
  }

  def finnish(): Unit ={
    // Finnish writing canvas
    g.dispose()
    javax.imageio.ImageIO.write(canvas, "png", new java.io.File(file_name))
  }
}
