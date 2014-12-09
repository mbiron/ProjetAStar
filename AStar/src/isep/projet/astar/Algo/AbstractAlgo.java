package isep.projet.astar.Algo;

import isep.projet.astar.IHM.AbstractFloor;

import java.util.LinkedList;

public abstract class AbstractAlgo {

	public abstract String getLabel();

	public abstract int getId();

	public abstract LinkedList<AbstractFloor> run(AbstractFloor StartPoint,
			AbstractFloor EndPoint);

	public String toString() {
		return getLabel();
	}
}
