object Main {
  def main(args: Array[String]) {
    def cantor(x: Float,y: Float,len: Float, img: drawing_module): Unit ={
      if(len >= 1){
        img.draw_line(x,y,x+len,y)
        val new_y = y + 20
        cantor(x,new_y,len/3,img)
        cantor(x+len*2/3,new_y,len/3,img)
      }
    }
    def circle_fractal_1(x: Double,y: Double,radius: Double,img: drawing_module): Unit = {
      if(radius > 1) {
        img.draw_circle(x,y,radius)
        val new_radius = radius * 0.75
        circle_fractal_1(x,y,new_radius,img)
      }
    }

    val cantor_img = new drawing_module("output/cantor.png",(500,500))
    cantor(10, 20, 500-20,cantor_img)
    cantor_img.finnish()

    val circle_f1 = new drawing_module("output/circle_f1.png",(500,500))
    circle_fractal_1(250,250,250,circle_f1)
    circle_f1.finnish()

  }
}
