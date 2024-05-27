package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Personagem;
import view.Frame;
import view.Game;
import view.OverPanel;
import view.SelectPanel;

public class ControleJogo implements KeyListener{

	public Frame frame;
	public Game game;
	public SelectPanel select =  new SelectPanel();
	public OverPanel over =  new OverPanel();
	ControlePersonagem1 controlPlayer1;
	ControlePersonagem2 controlPlayer2;
	boolean jogando = false;
	boolean jogador1Morto = false;
	boolean jogador2Morto = false;
	

	public ControleJogo(Frame frame, Game game) {
		this.frame = frame;
		this.game = game;
		
		//this.frame.addKeyListener(this);
		//controlPlayer1 = new ControlePersonagem1(this.frame,this.game);
		//controlPlayer2 = new ControlePersonagem2(this.frame,this.game);
		
		this.frame.setContentPane(this.select);
		this.frame.addKeyListener(this);
			//this.frame.setContentPane(this.game);
		/*if(jogando == true) {
			new Thread(play1).start();
			new Thread(play2).start();
		}*/
	}
	
	
	private Runnable play1 = new Runnable() {
		
		@Override
		public void run() {
			controlPlayer1 = new ControlePersonagem1(frame,game);
			while(true) {
				atualizaPlay1();
				
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					
				}
			}
		}};
		
		private Runnable play2 = new Runnable() {
			@Override
			public void run() {
				controlPlayer2 = new ControlePersonagem2(frame,game);
				while(true) {
					atualizaPlay2();
					
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						
					}
				}
			}};
		
	
	public  void atualizaPlay1() {
		game.personagem1.setBounds(game.personagem1.getX(),game.player1.y, game.player2.getLargura(), game.player2.getAltura());
		game.puch1.setBounds(game.personagem1.getX(), game.player1.y, game.player1.puchLargura, game.player1.puchAltura);
		
		game.player1.velocidade += game.player1.gravidade;
		game.player1.y += game.player1.velocidade;
			
		if(game.player1.y > game.player1.alturaChao) {
			game.personagem1.setBounds(game.personagem1.getX(),game.player1.y, game.player2.getLargura(), game.player2.getAltura());
			game.player1.y = game.player1.alturaChao;
			game.player1.velocidade = 0;
			game.player1.pulo = 0;
			
		}
		if(game.puch1.getX() + game.puch1.getWidth() > game.personagem2.getX() && game.puch1.getY() + game.puch1.getHeight() > game.personagem2.getY()  && game.player1.puch) {
			System.out.println("Puch1");
			game.player2.vidaAtual -= 10;
			game.barraVida2.setValue(game.player2.vidaAtual);
			game.barraVida2.setBounds(670, 20, 500, 50);
			game.player1.puch = false;
			if(game.player2.vidaAtual == 0) {
				jogador2Morto = true;
			}
		}
		if(jogador2Morto == true) {
			// Tela de win jogador 1
			this.frame.setContentPane(this.over);
		}
		/*if(emMovimento == true) {
			walk = new ImageIcon(sprite(idle));
			personagem.setIcon(walk);
			personagem.setBounds(posX,posY,larguraPers,alturaPers);
		}*/
	}

	public void atualizaPlay2() {
		//System.out.println("P2 " + game.player2.x);
		game.personagem2.setBounds(game.personagem2.getX(),game.player2.y, game.player2.getLargura(), game.player2.getAltura());
		game.puch2.setBounds(game.player2.x, game.player2.y, game.player2.puchLargura, game.player2.puchAltura);
		
		game.player2.velocidade += game.player2.gravidade;
		game.player2.y += game.player2.velocidade;
			
		if(game.player2.y >= game.player2.alturaChao) {
			game.personagem2.setBounds(game.personagem2.getX(),game.player2.y, game.player2.getLargura(), game.player2.getAltura());
			game.player2.y = game.player2.alturaChao;
			game.player2.velocidade = 0;
			game.player2.pulo = 0;
		}
		
		if(game.puch2.getX() < game.personagem1.getX() + game.personagem1.getWidth()&& game.puch2.getY() + game.puch2.getHeight() > game.personagem1.getY() && game.player2.puch) {
			System.out.println("Puch2");
			game.player1.vidaAtual -= 10;
			game.barraVida1.setValue(game.player1.vidaAtual);
			game.barraVida1.setBounds(20, 20, 500, 50);
			game.player2.puch = false;
			if(game.player1.vidaAtual == 0) {
				jogador1Morto = true;
			}
		}
		if(jogador1Morto == true) {
			// Tela de win jogador 2
			this.frame.setContentPane(this.over);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(jogando == false) {
			
			this.frame.setContentPane(this.game);
			new Thread(play1).start();
			new Thread(play2).start();
			jogando = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}