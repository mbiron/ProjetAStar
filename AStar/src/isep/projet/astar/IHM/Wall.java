package isep.projet.astar.IHM;

import java.awt.Color;

public class Wall extends AbstractFloor {

	public Wall() {
		super();
		this.setBackground(Color.DARK_GRAY);
		this.movCost = -1; // Can't go through walls!
	}

}
