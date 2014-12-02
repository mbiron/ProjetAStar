package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public abstract class AbstractFloor extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int movCost;
	private List<AbstractFloor> neighboors;

	public AbstractFloor() {
		setPreferredSize(new Dimension(20, 20));
		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		this.setBorder(whiteline);
		
		setVisible(true);
	}

	public List<AbstractFloor> getNeighboors() {
		return neighboors;
	}

	public int getMovCost() {
		return movCost;
	}

	public void setMovCost(int movCost) {
		this.movCost = movCost;
	}
}
