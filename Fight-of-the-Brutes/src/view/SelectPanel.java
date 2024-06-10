package view;

import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectPanel extends JPanel {
	
	
	
	public static JLabel cenario = new JLabel();
	
	public SelectPanel() {
		super();
		
		ImageIcon cenarioIcon = new ImageIcon(getClass().getResource("/cenario/cenarioKof99.jpg"));
		Image image = cenarioIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1200, 720,  java.awt.Image.SCALE_FAST);
		cenarioIcon = new ImageIcon(newimg);
		
		this.setVisible(true);
		this.setSize(1200,720);
		this.setLayout(null);
		
		cenario.setIcon(cenarioIcon);
		cenario.setBounds(0, 0, 1200, 720);
		this.add(cenario);
		
	}

	
	
}
