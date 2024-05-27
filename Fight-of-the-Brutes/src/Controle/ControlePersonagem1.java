package Controle;


import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import view.Frame;
import view.Game;
import modelo.Personagem;

public class ControlePersonagem1 extends Thread implements KeyListener{
	
	Frame frame;
	Game game;
	
	public ControlePersonagem1() {
		
	}
	public ControlePersonagem1(Frame frame, Game game) {
		this.frame = frame;
		this.game = game;
		frame.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == 87) { 
			if(game.player1.pulo < game.player1.alturaMax) {
				game.player1.velocidade -= game.player1.forca;
				game.player1.pulo++;
				game.personagem1.setBounds(game.personagem1.getX(),game.player1.y, game.player1.getLargura(), game.player1.getAltura());
				//tempo = 20;
				//if(e.getKeyCode() == 68) {
				//	posX += 14;
				//}
			}
		}
		if(e.getKeyCode() == 68 && game.personagem1.getX() <= 1070) {
			game.player1.x += 20;
			game.personagem1.setBounds(game.player1.x+20,game.personagem1.getY(), game.player1.getLargura(), game.player1.getAltura());
			
		}
		if(e.getKeyCode() == 65 && game.personagem1.getX() >= 0) {
			game.player1.x -= 20;
			game.personagem1.setBounds(game.player1.x-20,game.personagem1.getY(), game.player1.getLargura(), game.player1.getAltura());
			
		}
		if(e.getKeyCode() == 70) {
			
			//game.walk = new ImageIcon(getClass().getResource("/img/Attack (8).png"));
			//game.personagem1.setIcon(game.walk);
			game.player1.puch = true;
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
			game.player1.puch = false;
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
			
	
}
