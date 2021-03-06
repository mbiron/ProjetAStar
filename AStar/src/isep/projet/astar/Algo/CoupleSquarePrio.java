package isep.projet.astar.Algo;

import isep.projet.astar.IHM.AbstractFloor;

/**
 * This class describe data structure used for the A* Algorithm
 *
 */
public class CoupleSquarePrio implements Comparable<CoupleSquarePrio> {
	private AbstractFloor square;
	private int priority;

	public CoupleSquarePrio(AbstractFloor square, int priority) {
		this.setSquare(square);
		this.setPriority(priority);
	}

	public AbstractFloor getSquare() {
		return square;
	}

	public void setSquare(AbstractFloor square) {
		this.square = square;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String toString() {
		return ("square = " + square.getCoordinates().getX() + ","
				+ square.getCoordinates().getY() + " & priority = " + priority);
	}

	public int compareTo(CoupleSquarePrio obj) {
		int a = this.priority;
		int b = obj.priority;

		if (a < b)
			return -1;
		if (a > b)
			return 1;
		return 0;
	}

}
