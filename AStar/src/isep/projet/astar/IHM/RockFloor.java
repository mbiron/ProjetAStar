package isep.projet.astar.IHM;

import java.awt.Color;

public class RockFloor extends AbstractFloor {
	//ImageIcon back;

	public RockFloor() {
		super();
		this.setBackground(Color.GRAY);
		// back = new ImageIcon("/home/maxime/Rock.png");
		this.movCost = 1;
	}
	/*
	 * public void paintComponent(Graphics g){ super.paintComponent(g);;
	 * g.drawImage
	 * (back.getImage(),Constants.SQUARE_SIDE,Constants.SQUARE_SIDE,this); }
	 */
}
