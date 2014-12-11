package isep.projet.astar.IHM;

import isep.projet.astar.Data.Constants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RockFloor extends AbstractFloor {

	public RockFloor() {
		super();
		try {
			image = ImageIO.read(new File("Rock.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// this.setBackground(Color.GRAY);
		this.movCost = 1;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 2, 2, getWidth() - 2, getHeight() - 2, null);
		g2.dispose();
	}

}
