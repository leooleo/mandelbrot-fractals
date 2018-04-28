package scala

object SimpleFractals {
  def circle_fractal_1(x: Double,y: Double,radius: Double,img: drawing_module): Unit = {
    if(radius > 1) {
      img.draw_circle(x,y,radius)
      val new_radius = radius * 0.75
      circle_fractal_1(x,y,new_radius,img)
    }
  }
  def circle_fractal_2(x: Double,y: Double,radius: Double,img: drawing_module): Unit = {
    if(radius > 1) {
      img.draw_circle(x,y,radius)
      if(radius > 2){
        // Creates one circle at left and other at right
        circle_fractal_2(x-radius,y,radius/2,img)
        circle_fractal_2(x+radius,y,radius/2,img)
      }
    }
  }
  def circle_fractal_3(x: Double,y: Double,radius: Double,img: drawing_module): Unit = {
    if(radius > 1) {
      img.draw_circle(x,y,radius)
      if(radius > 4){
        // Creates one circle at left and other at right
        circle_fractal_3(x-radius,y,radius/2,img)
        circle_fractal_3(x+radius,y,radius/2,img)
        circle_fractal_3(x,y+radius,radius/2,img)
        circle_fractal_3(x,y-radius,radius/2,img)
      }
    }
  }
  def cantor(x: Float,y: Float,len: Float, img: drawing_module): Unit ={
    if(len >= 1){
      img.draw_line(x,y,x+len,y)
      val new_y = y + 20
      cantor(x,new_y,len/3,img)
      cantor(x+len*2/3,new_y,len/3,img)
    }
  }
}
