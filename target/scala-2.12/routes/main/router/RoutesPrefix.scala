// @GENERATOR:play-routes-compiler
// @SOURCE:/home/leo/programa/LP/fractals/conf/routes
// @DATE:Sat Apr 28 12:38:24 BRT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
