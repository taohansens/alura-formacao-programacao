let playerPoints = 0;
let botPoints = 0;

let xBall = 300;
let yBall = 200;
let diametro = 15;
let raio = diametro/2;

let movBallX = 6;
let movBallY = 6;

let rectWidth = 10;
let rectHeight = 90;

let xPlayer = 5;
let yPlayer = 150;

let xBot = 585;
let yBot = 150;

let speedYBot;

let isCollided = false;

let trilha;
let ponto;
let raquetada;


let difficultError = 0;

function preload() {
    trilha = loadSound("assets/audio/trilha.mp3");
    ponto = loadSound("assets/audio/ponto.mp3");
    raquetada = loadSound("assets/audio/raquetada.mp3");
}

function setup() {
    createCanvas(600, 400);
    trilha.loop();
}

function draw() {
    background(0);
    scoreBoard();
    scoreMark();
    showBall();
    movBall();
    collidBall();
    showBarPlayer(xPlayer, yPlayer)
    collidVerify(xPlayer, yPlayer);
    showBarPlayer(xBot, yBot)
    collidVerify(xBot, yBot);
    movPlayer();
    movBot();
    errorBot();
    correctBall()
}

function showBall() {
    circle(xBall,yBall, diametro);
}

function movBall(){
    xBall += movBallX;
    yBall += movBallY
}

function collidBall(){
    if(xBall + raio > width || xBall - raio < 0){
        movBallX *= -1;
    }
    if(yBall + raio > height || yBall - raio < 0){
        movBallY *= -1;
    }
}

function showBarPlayer(x,y) {
    rect(x, y, rectWidth, rectHeight);
}


function movPlayer() {
    if (keyIsDown(UP_ARROW)) {
        yPlayer -= 10;
    }
    if (keyIsDown(DOWN_ARROW)) {
        yPlayer += 10;
    }
}

function movBot() {
    speedYBot = yBall - yBot - rectWidth / 2 - 30;
    yBot += speedYBot + difficultError;
}

function collidVerify(x, y) {
    isCollided = collideRectCircle(x, y, rectWidth, rectHeight, xBall, yBall, raio);
    if (isCollided){
        movBallX *= -1;
        raquetada.play();
    }
}

function correctBall(){
    if (xBall - raio < 0){
        xBall = 23
    }
}

function errorBot() {
    if (botPoints >= playerPoints) {
        difficultError += 1
        if (difficultError >= 39){
            difficultError = 40
        }
    } else {
        difficultError -= 1
        if (difficultError <= 35){
            difficultError = 35
        }
    }
}


function scoreBoard() {
    stroke(255);
    textAlign(CENTER);
    textSize(16);
    fill(color(255, 140, 0));
    rect(150, 10, 40, 20);
    fill(255);
    text(playerPoints, 170, 26);
    fill(color(255, 140, 0));
    rect(450, 10, 40, 20);
    fill(255);
    text(botPoints, 470, 26);

}

function scoreMark() {
    if (xBall > 590) {
        playerPoints += 1;
        ponto.play();
    }
    if (xBall < 10) {
        botPoints += 1;
        ponto.play();
    }
}

