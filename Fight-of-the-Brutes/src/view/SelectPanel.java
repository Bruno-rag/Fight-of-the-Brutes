package view;

import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectPanel extends JPanel {
	
	ImageIcon cenarioIcon = new ImageIcon(getClass().getResource("/img/cenario.png"));
	public static JLabel cenario = new JLabel();
	
	public SelectPanel() {
		super();
		this.setVisible(true);
		this.setSize(1200,720);
		this.setLayout(null);
		
		cenario.setIcon(cenarioIcon);
		cenario.setBounds(0, 0, 1200, 720);
		this.add(cenario);
		
	}

	
	
}
