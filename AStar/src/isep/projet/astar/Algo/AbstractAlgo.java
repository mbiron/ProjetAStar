package isep.projet.astar.Algo;

import java.util.LinkedList;

import isep.projet.astar.Data.Constants.ALGOS_ID;
import isep.projet.astar.IHM.AbstractFloor;

public abstract class AbstractAlgo {

	public abstract String getLabel();

	public abstract int getId();

	public abstract LinkedList<AbstractFloor> run(AbstractFloor StartPoint,
			AbstractFloor EndPoint);

}
