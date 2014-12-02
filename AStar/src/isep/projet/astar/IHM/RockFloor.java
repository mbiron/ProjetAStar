package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Point;

public class RockFloor extends AbstractFloor {

	public RockFloor() {
		super();
		this.setBackground(Color.GRAY);
		this.movCost = 1;
	}

}
