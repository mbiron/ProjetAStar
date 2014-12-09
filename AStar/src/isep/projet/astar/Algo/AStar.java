package isep.projet.astar.Algo;

import isep.projet.astar.Data.Constants.ALGOS_ID;
import isep.projet.astar.IHM.AbstractFloor;

import java.util.LinkedList;

public class AStar extends AbstractAlgo {

	public AStar() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getLabel() {
		return "A*";
	}

	@Override
	public int getId() {
		return ALGOS_ID.ASTAR.ordinal();
	}

	@Override
	public LinkedList<AbstractFloor> compute(AbstractFloor StartPoint,
			AbstractFloor EndPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
