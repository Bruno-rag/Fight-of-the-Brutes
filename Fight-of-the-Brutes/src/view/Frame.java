package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.Personagem;

public class Frame extends JFrame{
	
	int alturaTela = 720;
	public int larguraTela = 1200;
	
	
	public Frame() {
		super("Uesb Fight");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(larguraTela, alturaTela);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//this.setContentPane(game);
		
		
		/*personagem.setIcon(walk);
		personagem.setBounds(1000, game.personagem.getY(), game.personagem.getLargura(), game.personagem.getAltura());
		this.add(personagem);*/
		//addMovimento();
		//run();
		
	}
	
	/*public void run() {
		while(true) {
			atualiza();
			limpar();
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				
			}
		}
		
	}

	public void limpar() {
		
		game.cenario.setBounds(0, 0, 1200, 720);
		this.add(game.cenario);	
	}

	public void atualiza() {
	
		game.personagem2.setBounds(game.personagem2.getX(), game.personagem2.getY(), game.personagem.getLargura(), game.personagem.getAltura());
		this.add(game.personagem2);
		
	}*/
	
}
