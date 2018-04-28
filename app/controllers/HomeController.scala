package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import java.io.File
import javax.imageio.ImageIO
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
import scala.Main
import scala.Mandelbrot
import scala.Julia

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def julia() = Action { implicit request: Request[AnyContent] =>  
    Main.main(Array("foo","blah"))
    Ok(views.html.simple_fractal())
  }

  def mandelbrot(iteration: String, centerReal: String, centerIm: String, scale: String) = Action { implicit request: Request[AnyContent] =>  
    val m = new Mandelbrot()
    var cR: Double = centerReal.toDouble
    var cI: Double = centerIm.toDouble
    var sC: Double = scale.toDouble
    var iT: Int = iteration.toInt

    val mImage = m.generate(840, 480, iT, ComplexNumber(cR, cI), sC, Palette.palette) 
    ImageIO.write(mImage, "png", new File("public/images/m.png"))
    Ok(views.html.simple_fractal())
  }
}
