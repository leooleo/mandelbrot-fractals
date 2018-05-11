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

$("#cantor").click(() => {
    $.get("/cantor", function(data) {
        $("#image").attr("src","assets/images/cantor.png");
    });
})


$("#c1").click(() => {
    $.get("/circle1", function(data) {
        $("#image").attr("src","assets/images/circle_f1.png");
    });
})


$("#c2").click(() => {
    $.get("/circle2", function(data) {
        $("#image").attr("src","assets/images/circle_f2.png");
    });
})


$("#c3").click(() => {
    $.get("/circle3", function(data) {
        $("#image").attr("src","assets/images/circle_f3.png");
    });
})


$("#mandelbrot").submit((data) => {
    let url = '/mandelbrot?';
    let i = 0;
    const target = data.target;
    while (data.target[i]) {
        if (data.target[i].name === "") break;
        url = `${url}&${data.target[i].name}=${data.target[i].value}`;
        i++;
    }
    $("#image").attr("src","assets/images/loading.gif");
    $.get(url, function(data) {
        $("#image").attr("src","assets/images/m.png?timestamp=" + new Date().getTime());
    });

    event.preventDefault();
})