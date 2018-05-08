window.onload = function() {
    var elements = 0;
    console.log(document.getElementById("fractal-1").offsetHeight );
    if (elements < document.getElementById("fractal-1").offsetHeight ) elements = document.getElementById("fractal-1").offsetHeight ;
    if (elements < document.getElementById("fractal-2").offsetHeight ) elements = document.getElementById("fractal-2").offsetHeight ;
    if (elements < document.getElementById("fractal-3").offsetHeight ) elements = document.getElementById("fractal-3").offsetHeight ;
    if (elements < document.getElementById("fractal-4").offsetHeight ) elements = document.getElementById("fractal-4").offsetHeight ;
    if (elements < document.getElementById("fractal-5").offsetHeight ) elements = document.getElementById("fractal-5").offsetHeight ;

    document.getElementById("fractal-1").style.height = elements + "px";
    document.getElementById("fractal-2").style.height = elements + "px";
    document.getElementById("fractal-3").style.height = elements + "px";
    document.getElementById("fractal-4").style.height = elements + "px";
    document.getElementById("fractal-5").style.height = elements + "px";
    console.log(elements);
}