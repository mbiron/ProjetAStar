package isep.projet.astar.Algo;

import isep.projet.astar.Data.Constants.ALGOS_ID;
import isep.projet.astar.IHM.AbstractFloor;

import java.util.LinkedList;
import java.util.PriorityQueue;

import org.apache.log4j.Logger;

public class Dijkstra extends AbstractAlgo {

	private static final Logger log = Logger.getLogger(Dijkstra.class);

	@Override
	public String getLabel() {
		return "Dijkstra";
	}

	@Override
	public int getAlgoId() {
		return ALGOS_ID.DIJKSTRA.ordinal();
	}

	@Override
	public LinkedList<AbstractFloor> compute(AbstractFloor StartPoint,
			AbstractFloor EndPoint) {
		PriorityQueue<AbstractFloor> path = new PriorityQueue<>();
		
		return null;
	}

}
