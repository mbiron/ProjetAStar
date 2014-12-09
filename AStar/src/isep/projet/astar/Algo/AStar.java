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
	public ALGOS_ID getId() {
		return ALGOS_ID.ASTAR;
	}

	@Override
	public LinkedList<AbstractFloor> run(AbstractFloor StartPoint,
			AbstractFloor EndPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
