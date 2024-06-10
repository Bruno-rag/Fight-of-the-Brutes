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
	Personagem player;
	String idPlayer;
	public ImageIcon paradoC = null;
	public ImageIcon parado = null;
	public ImageIcon soco = null;
	public ImageIcon pulo = null;
	public ImageIcon sofreDano = null;
	public ImageIcon andar = null;
	
	BufferedImage img = null;
	
	public ControleSprites(Game game, Personagem player, String idPlayer) {
		this.game = game;
		this.player = player;
		this.idPlayer = idPlayer;
	}

	public ImageIcon getSpriteParado() {
		new Thread(() -> {
			
				if(indexParado > 8) indexParado = 0;
				paradoC = new ImageIcon(getClass().getResource("/"+idPlayer+"/Gai Tendo_"+indexParado+".png")); // load the image to a imageIcon
				Image image = paradoC.getImage(); // transform it 
				Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
				parado = new ImageIcon(newimg);
				
				//parado = new ImageIcon(getClass().getResource("/player2/Gai Tendo_"+indexParado+".png"));
				
				indexParado++;     
         }).start();
		
		
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
		soco = new ImageIcon(getClass().getResource("/"+idPlayer+"/Gai Tendo_"+indexSoco+".png"));
		Image image = soco.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
		soco = new ImageIcon(newimg);
		//System.out.println(IndexParado);
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
		pulo = new ImageIcon(getClass().getResource("/"+idPlayer+"/Gai Tendo_"+indexPulo+".png"));
		Image image = pulo.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
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
		sofreDano = new ImageIcon(getClass().getResource("/"+idPlayer+"/Gai Tendo_"+indexDano+".png"));
		Image image = sofreDano.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
		sofreDano = new ImageIcon(newimg);
		indexDano++;
		
		return sofreDano;
	}

	public void setSofreDano(ImageIcon sofreDano) {
		this.sofreDano = sofreDano;
	}

	public ImageIcon getAndar() {
		if(indexAndar > 10) {
			indexAndar = 16;
			this.player.estadoPer = "parado";
		}
		andar = new ImageIcon(getClass().getResource("/"+idPlayer+"/Gai Tendo_"+indexAndar+".png"));
		Image image = andar.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 350,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
		andar = new ImageIcon(newimg);
		indexAndar++;
		return andar;
	}

	public void setAndar(ImageIcon andar) {
		this.andar = andar;
	}
	
	
}
