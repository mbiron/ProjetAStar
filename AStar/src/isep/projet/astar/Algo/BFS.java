package isep.projet.astar.Algo;

import isep.projet.astar.Data.Constants.ALGOS_ID;
import isep.projet.astar.IHM.AbstractFloor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * This class contains implementation of Breadth First Search Algorithm
 * 
 * @author maxime
 *
 */
public class BFS extends AbstractAlgo {

	private static final Logger log = Logger.getLogger(BFS.class);

	@Override
	public String getLabel() {
		return "Breadth First Search";
	}

	@Override
	public int getId() {
		return ALGOS_ID.BFS.ordinal();
	}

	@Override
	public LinkedList<AbstractFloor> compute(AbstractFloor StartPoint,
			AbstractFloor EndPoint) {
		LinkedList<AbstractFloor> squares = new LinkedList<>();
		squares.add(StartPoint);
		AbstractFloor current = StartPoint;
		Map<AbstractFloor, AbstractFloor> previous = new HashMap<>();

		log.info("start");
		while (current != EndPoint && !squares.isEmpty() && !stop) {
			current = squares.getFirst();
			squares.remove(current);

			if (current.isVisited())
				continue;
			current.setVisited();

			// log.debug(current);

			for (AbstractFloor neighboor : current.getNeighboors()) {
				if (!neighboor.isVisited() && (neighboor.getMovCost() > 0)) {
					squares.addLast(neighboor);
					previous.put(neighboor, current);
				}
			}
			// For testing
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		log.info("end algo");
		if(stop) return null;
		log.info("compute path");
		LinkedList<AbstractFloor> path = new LinkedList<>();
		
		/*
		 * ATTENTION : NE PAS DECOMMENTER CA SINON CA FAIT TOUT PETER!!!!!
		 * 
		current = EndPoint;
		path.add(current);
		while (current != StartPoint) {
			current = previous.get(current);
			path.addFirst(current);
		}
		log.info("return");
		*/
		return path;
	}
}
