package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dto.AbilityBbs;

public class ImageDetail extends JFrame{

	public ImageDetail(String img) {
		super("ImageView");
		
		JPanel imagePn = new JPanel(){
			ImageIcon image1 = new ImageIcon(img);

			public void paintComponent(Graphics g) {
				g.drawImage(image1.getImage(), 0, 0, 800, 600,  null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		
		imagePn.setBounds(0, 0, 800, 600);
		add(imagePn);
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setVisible(true);
	}
}
