package Controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.Frame;
import view.Game;

public class ControlePersonagem2 extends Thread implements KeyListener{
	Frame frame;
	Game game;
	
	public ControlePersonagem2() {
		
	}
	public ControlePersonagem2(Frame frame, Game game) {
		this.frame = frame;
		this.game = game;
		frame.addKeyListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(game.player2.jogadorMorto == false && game.player1.jogadorMorto == false) {
			if(e.getKeyCode() == 38) { 
				if(game.player2.pulo < game.player2.alturaMax) {
					game.player2.estadoPer = "pulo";
					game.player2.velocidade -= game.player2.forca;
					game.player2.pulo++;
					game.personagem2.setBounds(game.personagem2.getX(),game.player2.y, game.player2.getLargura(), game.player2.getAltura());
					//tempo = 20;
					//if(e.getKeyCode() == 68) {
					//	posX += 14;
					//}
				}
			}
			if(e.getKeyCode() == 39 && game.personagem2.getX() <= 1070) {
				game.player2.x += game.player1.deslocaento;
				game.personagem2.setBounds(game.player2.x,game.personagem2.getY(), game.player2.getLargura(), game.player2.getAltura());
				
			}
			if(e.getKeyCode() == 37 && game.personagem2.getX() >= 0 && game.personagem2.getX() > game.personagem1.getX()+ game.player1.getLarguraAbst()) {
				game.player2.x -= game.player1.deslocaento;
				game.personagem2.setBounds(game.player2.x,game.personagem2.getY(), game.player2.getLargura(), game.player2.getAltura());
			}
			
			if(e.getKeyCode() == 97) {
				if(game.player2.estadoPer == "parado") {
					game.player2.estadoPer = "soco";
					game.player2.puch = true;
				}
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		game.player2.puch = false;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
