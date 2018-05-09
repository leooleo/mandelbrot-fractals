window.onload = function() {
    var elements = 0;
    if (elements < document.getElementById("fractal-1").offsetHeight ) elements = document.getElementById("fractal-1").offsetHeight ;
    if (elements < document.getElementById("fractal-2").offsetHeight ) elements = document.getElementById("fractal-2").offsetHeight ;
    if (elements < document.getElementById("fractal-3").offsetHeight ) elements = document.getElementById("fractal-3").offsetHeight ;
    if (elements < document.getElementById("fractal-4").offsetHeight ) elements = document.getElementById("fractal-4").offsetHeight ;
    if (elements < document.getElementById("fractal-5").offsetHeight ) elements = document.getElementById("fractal-5").offsetHeight ;

    document.getElementById("fractal-1").style.minHeight = elements + "px";
    document.getElementById("fractal-2").style.minHeight = elements + "px";
    document.getElementById("fractal-3").style.minHeight = elements + "px";
    document.getElementById("fractal-4").style.minHeight = elements + "px";
    document.getElementById("fractal-5").style.minHeight = elements + "px";
}