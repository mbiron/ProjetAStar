package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
	private boolean visited;

	public AbstractFloor() {
		visited = false;
		
		setPreferredSize(new Dimension(20, 20));
		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		this.setBorder(whiteline);
		
		setVisible(true);
	}
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		if(this.isVisited()){
			this.setBackground(Color.WHITE);
		}
	}

	
	public void setVisited(){
		this.visited = true;
	}
	
	public boolean isVisited(){
		return visited;
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
