package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public abstract class AbstractFloorPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int movCost;

	public AbstractFloorPanel() {
		setPreferredSize(new Dimension(20, 20));
		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		this.setBorder(whiteline);
		
		setVisible(true);
	}

	public int getMovCost() {
		return movCost;
	}

	public void setMovCost(int movCost) {
		this.movCost = movCost;
	}
}
