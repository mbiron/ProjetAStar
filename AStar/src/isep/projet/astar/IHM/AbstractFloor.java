package isep.projet.astar.IHM;

import isep.projet.astar.Controler.GridControler;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
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
	protected BufferedImage image;

	public AbstractFloor() {
		visited = false;
		neighboors = new ArrayList<>();

		setPreferredSize(new Dimension(20, 20));
		setBackground(Color.BLACK);
		//Border whiteline = BorderFactory.createLineBorder(Color.BLACK, 5);
		//this.setBorder(whiteline);

		setVisible(true);
	}

	public void setVisited() {
		visited = true;
		// setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		repaint();
	}

	public void setColor(Color c){
		image = null;
		setBackground(c);
		repaint();
	}
	
	protected void displayImage(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 1, 1, getWidth() - 2, getHeight() - 2, null);
		g2.dispose();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		if (visited) {
			g2.setColor(Color.LIGHT_GRAY);
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(0, 0, getWidth(), 0);
			g2.drawLine(0, getHeight() - 1, getWidth(), getHeight());
			g2.drawLine(0, 0, 0, getHeight() - 1);
			g2.drawLine(getWidth(), 0, getWidth(), getHeight() - 1);
		}
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
	public String toString() {
		return coordinates.toString();
	}
}
