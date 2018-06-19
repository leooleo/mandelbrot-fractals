package controllers

import akka.actor._
import scala.concurrent._
import duration._

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
import scala.MainActor

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

  def cantor() = Action { implicit request: Request[AnyContent] =>
    Main.call_cantor()
    Ok(views.html.simple_fractal("cantor.png"))
  }

  def circle_1() = Action { implicit request: Request[AnyContent] =>
    Main.call_circle_1()
    Ok(views.html.simple_fractal("circle_f1.png"))
  }

  def circle_2() = Action { implicit request: Request[AnyContent] =>
    Main.call_circle_2()
    Ok(views.html.simple_fractal("circle_f2.png"))
  }

  def circle_3() = Action { implicit request: Request[AnyContent] =>
    Main.call_circle_3()
    Ok(views.html.simple_fractal("circle_f3.png"))
  }

  def mandelbrot(iteration: String, centerReal: String, centerIm: String, scale: String) = Action { implicit request: Request[AnyContent] =>  
  println("-0.2".toDouble)
    var cR: Double = centerReal.toDouble
    var cI: Double = centerIm.toDouble
    var sC: Double = scale.toDouble
    var iT: Int = iteration.toInt
    var width: Int = 840
    var height: Int = 480
 
    val system = ActorSystem("Fractals")
    system.actorOf(MainActor.props(width, height, ComplexNumber(cR, cI), ComplexNumber(0, 0), sC, iT, Palette.palette, false), "main")
    Await.result(system.whenTerminated, Duration.Inf)
    Ok(views.html.simple_fractal("result.png"))

    // val m = new Mandelbrot()
    // val mImage = m.generate(840, 480, iT, ComplexNumber(cR, cI), sC, Palette.palette) 
    // ImageIO.write(mImage, "png", new File("public/images/m.png"))
    // Ok(views.html.simple_fractal("m.png"))
  }

  def julia(iteration: String, centerReal: String, centerIm: String, zReal: String, zComplex: String, scale: String) = Action { implicit request: Request[AnyContent] =>  
    
    var cR: Double = centerReal.toDouble
    var cI: Double = centerIm.toDouble
    var sC: Double = scale.toDouble
    var iT: Int = iteration.toInt
    var width: Int = 840
    var height: Int = 480

    val system = ActorSystem("Fractals")
    system.actorOf(MainActor.props(width, height, ComplexNumber(cR, cI), ComplexNumber(zReal.toDouble, zComplex.toDouble), sC, iT, Palette.palette, true), "main")
    Await.result(system.whenTerminated, Duration.Inf)
    Ok(views.html.simple_fractal("result.png"))


    // val j = new Julia(ComplexNumber(zReal.toDouble, zComplex.toDouble))
    // val mImage = j.generate(840, 480, iT, ComplexNumber(cR, cI), sC, Palette.palette) 
    // ImageIO.write(mImage, "png", new File("public/images/j.png"))
    // Ok(views.html.simple_fractal("j.png"))
  }
}
