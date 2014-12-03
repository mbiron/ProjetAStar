package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Point;

public class ForestFloor extends AbstractFloor {

	public ForestFloor() {
		super();
		this.setBackground(Color.GREEN);
		this.movCost = 3;
	}

}
