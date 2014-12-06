package isep.projet.astar.IHM;

import isep.projet.astar.Controler.GridControler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.apache.log4j.Logger;

public abstract class AbstractFloor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AbstractFloor.class);
	protected int movCost;
	private List<AbstractFloor> neighboors;
	private boolean visited;
	private Point coordinates;

	public AbstractFloor() {
		visited = false;
		neighboors = new ArrayList<>();

		setPreferredSize(new Dimension(20, 20));
		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		this.setBorder(whiteline);

		setVisible(true);
	}
/*	
	public void isCurrent(){
		setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		repaint();
	}
*/
	public void setVisited() {
		visited = true;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		repaint();
	}

	public boolean isVisited() {
		return visited;
	}

	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}

	public List<AbstractFloor> getNeighboors() {
		if (neighboors.isEmpty()) {
			AbstractFloor[] squares = new AbstractFloor[4];

			squares[0] = GridControler.getInstance().getSquareAt(
					new Point(coordinates.x + 1, coordinates.y));
			squares[1] = GridControler.getInstance().getSquareAt(
					new Point(coordinates.x - 1, coordinates.y));
			squares[2] = GridControler.getInstance().getSquareAt(
					new Point(coordinates.x, coordinates.y + 1));
			squares[3] = GridControler.getInstance().getSquareAt(
					new Point(coordinates.x, coordinates.y - 1));

			for (AbstractFloor square : squares)
				if (square != null) {
					neighboors.add(square);
				}
		}
		return neighboors;
	}

	public int getMovCost() {
		return movCost;
	}
	
	// for debug
	public String toString(){
		return coordinates.toString();
	}
}
