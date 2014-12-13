package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends AbstractFloor {

	public Wall() {
		super();
		//this.setBackground(Color.DARK_GRAY);
		setBackground(Color.WHITE);
		try {
			image = ImageIO.read(new File("wall.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.movCost = -1; // Can't go though walls
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			displayImage(g);
		}
	}

}
