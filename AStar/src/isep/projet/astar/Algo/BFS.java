package isep.projet.astar.Algo;

import isep.projet.astar.IHM.AbstractFloor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class contain implementation of Breadth First Search Algorithm
 * 
 * @author maxime
 *
 */
public class BFS {

	private void algo(AbstractFloor StartPoint, AbstractFloor EndPoint) {
		LinkedList<AbstractFloor> frontière = new LinkedList<>();
		List<AbstractFloor> visited = new ArrayList<>();
		frontière.add(StartPoint);
		AbstractFloor current = StartPoint;

		while (current != EndPoint) {
			current = frontière.getFirst();
			frontière.remove(current);
			visited.add(current);
			for (AbstractFloor neighboor : current.getNeighboors()) {
				if (!visited.contains(neighboor))
					frontière.addLast(neighboor);
			}
		}
	}
}
