package isep.projet.astar.Algo;

import isep.projet.astar.Controler.GridControler;
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
	public int getAlgoId() {
		return ALGOS_ID.BFS.ordinal();
	}

	@Override
	public LinkedList<AbstractFloor> compute(AbstractFloor StartPoint,
			AbstractFloor EndPoint) {
		LinkedList<AbstractFloor> squares = new LinkedList<>();
		squares.add(StartPoint);
		AbstractFloor current = StartPoint;
		Map<AbstractFloor, AbstractFloor> previous = new HashMap<>();

		log.info("start " + this);
		while (current != EndPoint && !squares.isEmpty() && checkContinues()) {
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
			
			// Increase IHM step counter
			GridControler.getInstance().nextStep();
			
			
			try {
				Thread.sleep(GridControler.getInstance().getTimerValue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		log.info("end " + this);
		if(!checkContinues()) return null;
		log.info("compute path");
		LinkedList<AbstractFloor> path = new LinkedList<>();
		
		current = EndPoint;
		path.add(current);
		
		while (current != StartPoint) {
			current = previous.get(current);
			path.addFirst(current);
		}
		
		return path;
	}
}
