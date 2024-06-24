package Controle;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import modelo.Personagem;
import view.Game;

public class ControleSprites {
	Game game;
	int indexParado = 0;
	int indexSoco = 141;
	int indexPulo = 22;
	int indexDano = 78;
	int indexAndar = 10;
	int indexMorto = 434; 
	Personagem player;
	String idPlayer;
	String selectPerso;
	public ImageIcon paradoC = null;
	public ImageIcon parado = null;
	public ImageIcon soco = null;
	public ImageIcon pulo = null;
	public ImageIcon sofreDano = null;
	public ImageIcon andar = null;
	public ImageIcon morto = null;
	
	BufferedImage img = null;
	
	public ControleSprites(Game game, Personagem player, String idPlayer, String selectPerso) {
		this.game = game;
		this.player = player;
		this.idPlayer = idPlayer;
		this.selectPerso = selectPerso;
	}

	public ImageIcon getSpriteParado() {
				if(indexParado > 8) indexParado = 0;
				paradoC = new ImageIcon(getClass().getResource("/"+idPlayer+"/"+selectPerso+indexParado+".png"));
				Image image = paradoC.getImage(); // transform it 
				Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST);  
				parado = new ImageIcon(newimg);
				indexParado++;     
        	
		return parado;
	}

	public void setParado(ImageIcon parado) {
		this.parado = parado;
	}

	public ImageIcon getSoco() {
		if(indexSoco > 147) {
			indexSoco = 141;
			this.player.estadoPer = "parado";
		}
		soco = new ImageIcon(getClass().getResource("/"+idPlayer+"/"+selectPerso+indexSoco+".png"));
		Image image = soco.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST);  
		soco = new ImageIcon(newimg);
		indexSoco++;
		return soco;
	}

	public void setSoco(ImageIcon soco) {
		this.soco = soco;
	}

	public ImageIcon getPulo() {
		if(indexPulo > 29) {
			indexPulo = 22;
			this.player.estadoPer = "parado";
		}
		pulo = new ImageIcon(getClass().getResource("/"+idPlayer+"/"+selectPerso+indexPulo+".png"));
		Image image = pulo.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST);  
		pulo = new ImageIcon(newimg);
		indexPulo++;
		return pulo;
	}

	public void setPulo(ImageIcon pulo) {
		this.pulo = pulo;
	}

	public ImageIcon getSofreDano() {
		if(indexDano > 79) {
			indexDano = 78;
			this.player.estadoPer = "parado";
		}
		sofreDano = new ImageIcon(getClass().getResource("/"+idPlayer+"/"+selectPerso+indexDano+".png"));
		Image image = sofreDano.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST); 
		sofreDano = new ImageIcon(newimg);
		indexDano++;
		
		return sofreDano;
	}

	public void setSofreDano(ImageIcon sofreDano) {
		this.sofreDano = sofreDano;
	}
	public ImageIcon getAndar() {
		if(indexAndar > 16) {
			indexAndar = 10;
			this.player.estadoPer = "parado";
		}
		andar = new ImageIcon(getClass().getResource("/"+idPlayer+"/"+selectPerso+indexAndar+".png"));
		Image image = andar.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST);   
		andar = new ImageIcon(newimg);
		indexAndar++;
		return andar;
	}

	public void setAndar(ImageIcon andar) {
		this.andar = andar;
	}

	public ImageIcon getMorto() {
		if(indexMorto <= 436) {
			
			indexMorto++;
			
			morto = new ImageIcon(getClass().getResource("/"+idPlayer+"/"+selectPerso+indexMorto+".png"));
			Image image = morto.getImage();
			Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST);   
			morto = new ImageIcon(newimg);
			
		}
		if(indexMorto == 437) {
			
			morto = new ImageIcon(getClass().getResource("/"+idPlayer+"/"+selectPerso+"437.png"));
			Image image = morto.getImage(); 
			Image newimg = image.getScaledInstance(200, 100,  java.awt.Image.SCALE_FAST);   
			morto = new ImageIcon(newimg);
			game.gameOver = true;
		}
		
		return morto;
	}

	public void setMorto(ImageIcon morto) {
		this.morto = morto;
	}
	
	
}
