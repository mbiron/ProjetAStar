package isep.projet.astar.Algo;

import isep.projet.astar.IHM.AbstractFloor;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contain implementation of Breadth First Search Algorithm
 * 
 * @author maxime
 *
 */
public class BFS {

	private void algo(AbstractFloor StartPoint, AbstractFloor EndPoint) {
		List<AbstractFloor> frontière = new ArrayList<>();
		List<AbstractFloor> visited = new ArrayList<>();
		frontière.add(StartPoint);
		AbstractFloor current = StartPoint;
		int num = 0;
		while (current != EndPoint) {
			current = frontière.get(num++);
			frontière.remove(current);
			visited.add(current);
			for (AbstractFloor neighboor : current.getNeighboors()) {
				if (!visited.contains(neighboor))
					frontière.add(neighboor);

			}
		}
	}
}
