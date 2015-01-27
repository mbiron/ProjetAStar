package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SandFloor extends AbstractFloor {

	public SandFloor() {
		super();
		try {
			image = ImageIO.read(new File("sand.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// this.setBackground(Color.YELLOW);
		this.movCost = 20;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		displayImage(g);
	}

}
