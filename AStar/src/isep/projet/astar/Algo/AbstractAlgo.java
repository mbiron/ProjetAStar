package isep.projet.astar.Algo;

import isep.projet.astar.Controler.GridControler;
import isep.projet.astar.IHM.AbstractFloor;

import java.awt.Color;
import java.util.LinkedList;

import org.apache.log4j.Logger;

/*
 * This class describes algorithms. 
 * They extend thread to be executed in parallel of IMH threads.
 *  
 * 
 */
public abstract class AbstractAlgo extends Thread {

	private static final Logger log = Logger.getLogger(AbstractAlgo.class);
	private volatile boolean stop = false;
	private volatile boolean paused = false;

	public abstract String getLabel();

	public abstract int getAlgoId();

	public abstract LinkedList<AbstractFloor> compute(AbstractFloor StartPoint,
			AbstractFloor EndPoint);

	protected synchronized boolean checkContinues() {
		while (paused && !stop);
		return !stop;
	}

	public String toString() {
		return getLabel();
	}

	public void pauseAlgo() {
		log.debug("pauseAlgo");
		paused = true;
	}

	public void resumeAlgo() {
		log.debug("resumeAlgo");
		paused = false;
	}

	public void stopRunning() {
		stop = true;
	}

	public void run() {
		stop = false;
		LinkedList<AbstractFloor> path = compute(GridControler.getInstance()
				.getStartPoint(), GridControler.getInstance().getEndPoint());

		if (!stop && path != null) {
			GridControler.getInstance().drawPath(path, Color.GREEN);
		}
	}
}
