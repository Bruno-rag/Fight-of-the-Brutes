package modelo;

public class Personagem {

	public int altura = 334;
	static int largura = 200;
	public int x;
	public int y;
	public int gravidade = 7;
	public int velocidade = 0;
	public int alturaChao = 720-334;
	public int pulo = 0;
	public int forca = 50;
	public int alturaMax = 1;
	public int puchLargura = 150;
	public int puchAltura = 150;
	public boolean puch = false;
	public int vidaTotal = 100;
	public int vidaAtual = 100;
	public Personagem(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Personagem() {
		
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
