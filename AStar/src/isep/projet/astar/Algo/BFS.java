package isep.projet.astar.Algo;

import isep.projet.astar.IHM.AbstractFloor;

import java.util.LinkedList;

/**
 * This class contains implementation of Breadth First Search Algorithm
 * 
 * @author maxime
 *
 */
public class BFS {

	public static void algo(AbstractFloor StartPoint, AbstractFloor EndPoint) {
		LinkedList<AbstractFloor> frontière = new LinkedList<>();
		//List<AbstractFloor> visited = new ArrayList<>();
		frontière.add(StartPoint);
		AbstractFloor current = StartPoint;

		while (current != EndPoint) {
			current = frontière.getFirst();
			frontière.remove(current);
			current.setVisited();
			for (AbstractFloor neighboor : current.getNeighboors()) {
				if (!neighboor.isVisited())
					frontière.addLast(neighboor);
			}
			// For testing
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
