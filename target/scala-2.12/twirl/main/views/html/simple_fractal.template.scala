
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object simple_fractal extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/()),format.raw/*3.4*/(""" """),_display_(/*3.6*/main("Welcome to Play")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""
    """),format.raw/*4.5*/("""<h1> Teste </h1>
    <img src="m.png">
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Apr 28 12:45:49 BRT 2018
                  SOURCE: /home/leo/programa/LP/fractals/app/views/simple_fractal.scala.html
                  HASH: ea3164a0185a15867deeafb35350f1264c943bb4
                  MATRIX: 731->1|827->4|854->6|875->8|902->10|933->33|972->35|1003->40
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|27->3|28->4
                  -- GENERATED --
              */
          