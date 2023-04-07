let imagemDaEstrada;
let imagemDoAtor;
let imagemCarro;
let imagemCarro2;
let imagemCarro3;

function preload(){
    imagemDaEstrada = loadImage("assets/images/estrada.png");
    imagemDoAtor = loadImage("assets/images/ator-1.png");
    imagemCarro = loadImage("assets/images/carro-1.png");
    imagemCarro2 = loadImage("assets/images/carro-2.png");
    imagemCarro3 = loadImage("assets/images/carro-3.png");
    imagemCarros = [imagemCarro, imagemCarro2, imagemCarro3, imagemCarro, imagemCarro2, imagemCarro3]
    somDaTrilha = loadSound("assets/audio/trilha.mp3");
    somDaColisao = loadSound("assets/audio/colidiu.mp3")
    somDoPonto= loadSound("assets/audio/pontos.wav");
}