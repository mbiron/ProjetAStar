package isep.projet.astar.Algo;

import isep.projet.astar.Controler.GridControler;
import isep.projet.astar.IHM.AbstractFloor;

import java.awt.Color;
import java.util.LinkedList;

import org.apache.log4j.Logger;

public abstract class AbstractAlgo implements Runnable {

	private static final Logger log = Logger.getLogger(AbstractAlgo.class);
	protected volatile boolean stop = false;

	public abstract String getLabel();

	public abstract int getId();

	public abstract LinkedList<AbstractFloor> compute(AbstractFloor StartPoint,
			AbstractFloor EndPoint);

	public String toString() {
		return getLabel();
	}

	public void stopRunning() {
		stop = true;
	}

	public void run() {
		stop = false;
		log.info("thread!");
		GridControler.getInstance().getStartPoint();
		log.info("instance");
		log.info(stop);
		LinkedList<AbstractFloor> path = compute(GridControler.getInstance().getStartPoint(),
				GridControler.getInstance().getEndPoint());
		log.info("path computed");
		//if (!stop)
		//	GridControler.getInstance().drawPath(path, Color.CYAN);
	}
}
