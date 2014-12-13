package isep.projet.astar.IHM;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
		if (image != null) {
			displayImage(g);
		}
	}

}
