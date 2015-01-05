package isep.projet.astar.Algo;

import isep.projet.astar.Controler.GridControler;
import isep.projet.astar.Data.Constants.ALGOS_ID;
import isep.projet.astar.IHM.AbstractFloor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

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
		log.info("à la déclaration, squares = "+squares.toString());
		CoupleSquarePrio firstCouple = new CoupleSquarePrio(StartPoint, 0);
		squares.add(firstCouple);
		log.info("après ajout firstCouple, squares = "+squares.toString());
		AbstractFloor current = StartPoint;
		Map<AbstractFloor, AbstractFloor> previous = new HashMap<>();
		Map<AbstractFloor, Integer> cost_so_far = new HashMap<>();
		previous.put(StartPoint, null);
		cost_so_far.put(StartPoint, 0);

		log.info("start " + this);
		while (current != EndPoint && !squares.isEmpty() && checkContinues()) {
			log.info("avant remove, squares = "+squares.toString());
			CoupleSquarePrio currentCouple = squares.remove();
			log.info("après remove, squares = "+squares.toString());
			current = currentCouple.getSquare();

			if (current.isVisited())
				continue;
			current.setVisited();

			// log.debug(current);

			for (AbstractFloor neighboor : current.getNeighboors()) {
				int neighboorMoveCost = neighboor.getMovCost();
				if (neighboorMoveCost > 0) {
					int new_cost = (cost_so_far.get(current) + neighboorMoveCost);
					if (!cost_so_far.containsKey(neighboor) || new_cost < cost_so_far.get(neighboor)) {
						cost_so_far.put(neighboor, new_cost);
						int priority = new_cost + heuristic(EndPoint, neighboor);
						System.out.println("priority = "+priority+" ==> "+new_cost+" + "+heuristic(EndPoint, neighboor));
						CoupleSquarePrio newCouple = new CoupleSquarePrio(neighboor, priority);
						log.info("avant ajout, squares = "+squares.toString());
						squares.add(newCouple);
						log.info("après ajout, squares = "+squares.toString());
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

		log.info("end " + this);
		if (!checkContinues())
			return null;
		log.info("compute path");
		log.info("Total move cost = " + cost_so_far.get(EndPoint));
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

	 private int heuristic(AbstractFloor from, AbstractFloor to){
		 return (int) (Math.abs(from.getCoordinates().getX() - to.getCoordinates().getX()) + Math.abs(from.getCoordinates().getY() - to.getCoordinates().getY()));
	 }

}
