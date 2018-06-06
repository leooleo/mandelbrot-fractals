function divChangeHeight(div) {
    $('#'+div).height($( window ).height());
}

function divsChange() {
    for (var i = 1; i < 7; i++)
        divChangeHeight('fractal-'+i);
}

$( document ).ready(function() {
    divsChange();
})

$( window ).resize(function() {
    divsChange();
})

$("#cantor").click(() => {
    $("#image-cantor").attr("src","assets/images/loading.gif");
    $.get("/cantor", function(data) {
        $("#image-cantor").attr("src","assets/images/cantor.png");
    });
})


$("#c1").click(() => {
    $("#image-c1").attr("src","assets/images/loading.gif");
    $.get("/circle1", function(data) {
        $("#image-c1").attr("src","assets/images/circle_f1.png");
    });
})


$("#c2").click(() => {
    $("#image").attr("src","assets/images/loading.gif");
    $.get("/circle2", function(data) {
        $("#image").attr("src","assets/images/circle_f2.png");
    });
})


$("#c3").click(() => {
    $("#image").attr("src","assets/images/loading.gif");
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


$("#julia").submit((data) => {
    let url = '/julia?';
    let i = 0;
    const target = data.target;
    while (data.target[i]) {
        if (data.target[i].name === "") break;
        url = `${url}&${data.target[i].name}=${data.target[i].value}`;
        i++;
    }
    $("#image").attr("src","assets/images/loading.gif");
    $.get(url, function(data) {
        $("#image").attr("src","assets/images/j.png?timestamp=" + new Date().getTime());
    });

    event.preventDefault();
})