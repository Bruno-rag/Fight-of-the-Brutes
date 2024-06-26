package Controle;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.Frame;
import view.Game;
import view.OverPanel;
import view.SelectPanel;

public class ControleJogo implements KeyListener{

	public Frame frame;
	public Game game = new Game();
	public SelectPanel select =  new SelectPanel();
	public OverPanel over =  new OverPanel();
	ControlePersonagem1 controlPlayer1;
	ControlePersonagem2 controlPlayer2;
	ControleSprites controlSprites1;
	ControleSprites controlSprites2;
	boolean jogando = false;
	boolean thread = false;
	
	
	public ControleJogo(Frame frame) {
		this.frame = frame;
		//this.game = game;
		controlSprites1 = new ControleSprites(this.game, this.game.player1, "player1","Iori Yagami_");
		controlSprites2 = new ControleSprites(this.game, this.game.player2, "player2","Kim_");
		//controlPlayer1 = new ControlePersonagem1(frame,game);
		//controlPlayer2 = new ControlePersonagem2(frame,game);
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
					Thread.sleep(120);
				} catch (Exception e) {
					
				}
			}
		}
	};
		
	private Runnable play2 = new Runnable() {
		@Override
		public void run() {
			controlPlayer2 = new ControlePersonagem2(frame,game);
			while(true) {
				atualizaPlay2();
				
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					
				}
			}
		}
	};
	
	
	public  void atualizaPlay1() {
		
		
		//game.personagem1.setBounds(game.personagem1.getX(),game.player1.y, game.player1.getLargura(), game.player1.getAltura());
		//game.puch1.setBounds(game.personagem1.getX()+20, game.player1.y, game.player1.puchLargura, game.player1.puchAltura);
		
		
		game.player1.velocidade += game.player1.gravidade;
		game.player1.y += game.player1.velocidade;
		
		//System.out.println("test");	
		if(game.player1.estadoPer == "parado") {
			game.personagem1.setIcon(controlSprites1.getSpriteParado());
		}
		
		if(game.player1.estadoPer == "soco") {
			game.personagem1.setIcon(controlSprites1.getSoco());
		}
		
		if(game.player1.estadoPer == "pulo") {
			game.player1.velocidade += game.player1.gravidade;
			game.player1.y += game.player1.velocidade;
			game.personagem1.setIcon(controlSprites1.getPulo());
		}
		if(game.player1.estadoPer == "sofreDano") {
			game.personagem1.setIcon(controlSprites1.getSofreDano());
		}
		if(game.player1.estadoPer == "morto") {
			game.personagem1.setIcon(controlSprites1.getMorto());
		}
		
		if(game.player1.y > game.player1.alturaChao) {
			game.personagem1.setBounds(game.personagem1.getX(),game.player1.y, game.player1.getLargura(), game.player1.getAltura());
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
			game.player2.estadoPer = "sofreDano";
			if(game.player2.vidaAtual == 0) {
				game.player2.jogadorMorto = true;
			}
		}
		if(game.player1.jogadorMorto == true) {
			// Tela de win jogador 1
			game.player1.estadoPer = "morto";
			if(game.gameOver) {
				game.personagem1.setBounds(game.personagem1.getX(),400, game.player1.getLargura(), game.player1.getAltura());
				game.puch1.setBounds(game.personagem1.getX()+20, game.player1.y, game.player1.puchLargura, game.player1.puchAltura);
				
				try {
					 Thread.sleep( 5000 );
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				clear();
			}
			
			//this.frame.setContentPane(this.over);
		}
		/*if(emMovimento == true) {
			walk = new ImageIcon(sprite(idle));
			personagem.setIcon(walk);
			personagem.setBounds(posX,posY,larguraPers,alturaPers);
		}*/
		if(game.player1.jogadorMorto == false) {
			game.personagem1.setBounds(game.personagem1.getX(),game.player1.y, game.player1.getLargura(), game.player1.getAltura());
			game.puch1.setBounds(game.personagem1.getX()+20, game.player1.y, game.player1.puchLargura, game.player1.puchAltura);
		}
		
	}

	public void atualizaPlay2() {
		//System.out.println("P2 " + game.player2.x);
		//game.personagem2.setBounds(game.personagem2.getX(),game.player2.y, game.player2.getLargura(), game.player2.getAltura());
		//game.puch2.setBounds(game.player2.x+20, game.player2.y, game.player2.puchLargura, game.player2.puchAltura);
		
		
		game.player2.velocidade += game.player2.gravidade;
		game.player2.y += game.player2.velocidade;
		
		
		
		if(game.player2.estadoPer == "parado") {
			game.personagem2.setIcon(controlSprites2.getSpriteParado());
		}
		
		if(game.player2.estadoPer == "soco") {
			game.personagem2.setIcon(controlSprites2.getSoco());
		}
		
		if(game.player2.estadoPer == "pulo") {
			game.personagem2.setIcon(controlSprites2.getPulo());
		}
		
		
		if(game.player2.estadoPer == "sofreDano") {
			game.personagem2.setIcon(controlSprites2.getSofreDano());
		}
		if(game.player2.estadoPer == "morto") {
			game.personagem2.setIcon(controlSprites2.getMorto());
		}
		if(game.player2.y >= game.player2.alturaChao) {
			game.personagem2.setBounds(game.personagem2.getX(),game.player2.y, game.player2.getLargura(), game.player2.getAltura());
			game.player2.y = game.player2.alturaChao;
			game.player2.velocidade = 0;
			game.player2.pulo = 0;
		}
		
		if(game.player2.puch == true && game.puch2.getX() < game.personagem1.getX() + game.personagem1.getWidth()&& game.puch2.getY() + game.puch2.getHeight() > game.personagem1.getY() && game.puch2.getX() + game.puch2.getWidth() > game.personagem1.getX()) {
			System.out.println("Puch2");
			game.player1.vidaAtual -= 10;
			game.barraVida1.setValue(game.player1.vidaAtual);
			game.barraVida1.setBounds(20, 20, 500, 50);
			game.player2.puch = false;
			game.player1.estadoPer = "sofreDano";
			if(game.player1.vidaAtual == 0) {
				game.player1.jogadorMorto = true;
			}
		}
		if(game.player2.jogadorMorto == true) {
			// Tela de win jogador 2
			game.player2.estadoPer = "morto";
			
			if(game.gameOver) {
				
				game.personagem2.setBounds(game.personagem2.getX(),400, game.player2.getLargura(), game.player2.getAltura());
				game.puch2.setBounds(game.player2.x+20, game.player2.y, game.player2.puchLargura, game.player2.puchAltura);
				
				try {
					 Thread.sleep( 5000 );
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				clear();
			}
			
			//this.frame.setContentPane(this.over);
		}
		if(game.player2.jogadorMorto == false) {
			game.personagem2.setBounds(game.personagem2.getX(),game.player2.y, game.player2.getLargura(), game.player2.getAltura());
			game.puch2.setBounds(game.player2.x+20, game.player2.y, game.player2.puchLargura, game.player2.puchAltura);
		}
		
	}
	
	public void clear() {
		this.game = new Game();
		jogando = false;
		this.frame.setContentPane(this.select);
		controlSprites1 = new ControleSprites(this.game, this.game.player1, "player1","Iori Yagami_");
		controlSprites2 = new ControleSprites(this.game, this.game.player2, "player2","Kim_");
		controlPlayer1 = new ControlePersonagem1(frame,game);
		controlPlayer2 = new ControlePersonagem2(frame,game);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(jogando == false) {
			
			this.frame.setContentPane(this.game);
			if(thread == false) {
				new Thread(play1).start();
				new Thread(play2).start();
				thread = true;
			}
			
			jogando = true;
			
			// Thread com lambda function
			/*new Thread(()->{
				
			}).start();
			new Thread(()->{
				
			}).start();
			*/
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}