package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import modelo.Personagem;

public class Game extends JPanel{
	
	public int alturaChao = 720-334;
	
	public Personagem player1 = new Personagem(40, 500);
	public Personagem player2 = new Personagem(1000, 500);
	
	public  JLabel personagem1 = new JLabel();
	public  JLabel personagem2 = new JLabel();
	
	public JLabel puch1 = new JLabel();
	public JLabel puch2 = new JLabel();
	
	//ImageIcon cenarioIcon = new ImageIcon(getClass().getResource("/cenario/cenarioSaopaulo.png"));
	public static JLabel cenario = new JLabel();
	
	public JProgressBar barraVida1 = new JProgressBar();
	public JProgressBar barraVida2 = new JProgressBar();
	
	public boolean gameOver = false;
	
	public Game() {
		this.setVisible(true);
		this.setSize(1200,720);
		this.setLayout(null);
		
		ImageIcon cenarioIcon = new ImageIcon(getClass().getResource("/cenario/kofXV.gif"));
		Image image = cenarioIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1200, 720,  java.awt.Image.SCALE_FAST);
		cenarioIcon = new ImageIcon(newimg);
		
		//personagem1.setIcon(walk);
		personagem1.setBounds(player1.getX(), player1.getY(), player1.getLargura(), player1.getAltura());
		this.add(personagem1);
		puch1.setBounds(player1.getX()+player1.getLargura(), player1.getY()+player1.getAltura(), player1.puchLargura, player1.puchAltura);
		//this.add(puch1);
		
		personagem2.setBounds(player2.getX(), player2.getY(), player2.getLargura(), player2.getAltura());
		this.add(personagem2);
		puch2.setBounds(player2.getX(), player2.getY(), player2.puchLargura, player2.puchAltura);
		
		barraVida1.setBounds(20, 20, 500, 50);
		barraVida1.setValue(player1.vidaAtual);
		barraVida1.setMaximum(player1.vidaTotal);
		barraVida1.setForeground(Color.green);
		this.add(barraVida1);
		
		barraVida2.setBounds(670, 20, 500, 50);
		barraVida2.setValue(player2.vidaAtual);
		barraVida2.setMaximum(player2.vidaTotal);
		barraVida2.setForeground(Color.green);
		this.add(barraVida2);
		
		cenario.setIcon(cenarioIcon);
		cenario.setBounds(0, 0, 1200, 720);
		this.add(cenario);
	}
}
