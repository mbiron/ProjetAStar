package isep.projet.astar.IHM;

import javax.swing.JPanel;

public abstract class AbstractFloorPanel extends JPanel {
	
	private int movCost;

	public AbstractFloorPanel() {
		// TODO Auto-generated constructor stub
	}

	public int getMovCost() {
		return movCost;
	}

	public void setMovCost(int movCost) {
		this.movCost = movCost;
	}


}
