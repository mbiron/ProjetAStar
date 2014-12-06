package isep.projet.astar.Algo;

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
public class BFS {

	private static final Logger log = Logger.getLogger(BFS.class);

	public static LinkedList<AbstractFloor> algo(AbstractFloor StartPoint,
			AbstractFloor EndPoint) {
		LinkedList<AbstractFloor> squares = new LinkedList<>();
		squares.add(StartPoint);
		AbstractFloor current = StartPoint;
		Map<AbstractFloor, AbstractFloor> previous = new HashMap<>();

		while (current != EndPoint && !squares.isEmpty()) {
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

		current = EndPoint;
		LinkedList<AbstractFloor> path = new LinkedList<>();
		path.add(current);
		while (current != StartPoint) {
			current = previous.get(current);
			path.addFirst(current);
		}
		return path;
	}
}
