package isep.projet.astar.Algo;

import isep.projet.astar.Controler.GridControler;
import isep.projet.astar.Data.Constants.ALGOS_ID;
import isep.projet.astar.IHM.AbstractFloor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

import org.apache.log4j.Logger;

/**
 * This class contains implementation of A* Algorithm
 * 
 * @author AymericDH
 *
 */
public class AStar extends AbstractAlgo {

	private static final Logger log = Logger.getLogger(AStar.class);

	@Override
	public String getLabel() {
		return "A*";
	}

	@Override
	public int getAlgoId() {
		return ALGOS_ID.ASTAR.ordinal();
	}

	@Override
	public LinkedList<AbstractFloor> compute(AbstractFloor StartPoint,
			AbstractFloor EndPoint) {

		PriorityQueue<CoupleSquarePrio> squares = new PriorityQueue<CoupleSquarePrio>();
		Map<AbstractFloor, AbstractFloor> previous = new HashMap<>();
		Map<AbstractFloor, Integer> totCost = new HashMap<>();
		AbstractFloor current = StartPoint;

		squares.add(new CoupleSquarePrio(StartPoint, 0));

		previous.put(StartPoint, null);
		totCost.put(StartPoint, 0);

		while (current != EndPoint && !squares.isEmpty() && checkContinues()) {

			CoupleSquarePrio currentCouple = squares.remove();

			current = currentCouple.getSquare();

			if (!current.isVisited())
				current.setVisited();

			for (AbstractFloor neighboor : current.getNeighboors()) {
				int neighboorMoveCost = neighboor.getMovCost();
				if (neighboorMoveCost > 0) {
					int new_cost = (totCost.get(current) + neighboorMoveCost);

					if (!totCost.containsKey(neighboor)
							|| new_cost < totCost.get(neighboor)) {
						totCost.put(neighboor, new_cost);
						int priority = new_cost
								+ heuristic(EndPoint, neighboor);
						squares.add(new CoupleSquarePrio(neighboor, priority));
						previous.put(neighboor, current);
					}
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

		if (!checkContinues())
			return null;
		// log.info("Total move cost = " + totCost.get(EndPoint));

		LinkedList<AbstractFloor> path = new LinkedList<>();

		current = EndPoint;
		path.add(current);

		while (current != StartPoint) {
			current = previous.get(current);
			path.addFirst(current);
		}

		return path;

		/*******************************************************************/
	}

	private int heuristic(AbstractFloor from, AbstractFloor to) {
		return (int) (Math.abs(from.getCoordinates().getX()
				- to.getCoordinates().getX()) + Math.abs(from.getCoordinates()
				.getY() - to.getCoordinates().getY()));
	}

}
