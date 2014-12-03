package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Point;

public class WaterFloor extends AbstractFloor {

	public WaterFloor() {
		super();
		this.setBackground(Color.BLUE);
		this.movCost = 7;
	}

}
