package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ForestFloor extends AbstractFloor {

	public ForestFloor() {
		super();
		try {
			image = ImageIO.read(new File("forest.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// this.setBackground(Color.GREEN);
		this.movCost = 10;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		displayImage(g);
	}

}
