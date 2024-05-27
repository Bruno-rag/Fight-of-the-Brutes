package Controle;

import view.Frame;
import view.Game;

public class Main {
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		Game game = new Game();
		new ControleJogo(frame, game);
		
	}
}
