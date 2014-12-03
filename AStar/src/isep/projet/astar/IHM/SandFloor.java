package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Point;

public class SandFloor extends AbstractFloor {

	public SandFloor() {
		super();
		this.setBackground(Color.YELLOW);
		this.movCost = 4;
	}

}
