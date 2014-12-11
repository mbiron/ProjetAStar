package isep.projet.astar.Controler;

import isep.projet.astar.Algo.AStar;
import isep.projet.astar.Algo.AbstractAlgo;
import isep.projet.astar.Algo.BFS;
import isep.projet.astar.Data.AbstractMap;
import isep.projet.astar.Data.Map1;
import isep.projet.astar.Data.Map2;
import isep.projet.astar.IHM.AbstractFloor;
import isep.projet.astar.IHM.GridPanel;
import isep.projet.astar.IHM.MainFrame;
import isep.projet.astar.IHM.RockFloor;
import isep.projet.astar.IHM.Wall;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class GridControler {

	private static final Logger log = Logger.getLogger(GridControler.class);
	private static GridControler instance;
	private MainFrame mainFrame = null;
	private Map<Point, AbstractFloor> squares;
	private AbstractFloor startPoint;
	private AbstractFloor endPoint;
	private List<AbstractMap> mapsList;
	private List<AbstractAlgo> algosList;
	private AbstractAlgo runningAlgo;
	private Thread algoThread = null;
	private int stepCounter;

	private enum TIMER {
		E_0MS, E_50MS, E_100MS, E_500MS
	};

	private TIMER timerValue;

	private GridControler() {
		initMapsList();
		initAlgosList();
		squares = new HashMap<>();
		timerValue = TIMER.E_50MS;
	}

	// ********************************************//
	// ***************** Getters ******************//
	// ********************************************//

	public static synchronized GridControler getInstance() {
		if (instance == null) {
			instance = new GridControler();
		}
		return instance;
	}

	public synchronized AbstractFloor getStartPoint() {
		return startPoint;
	}

	public synchronized AbstractFloor getEndPoint() {
		return endPoint;
	}

	public synchronized AbstractFloor getSquareAt(Point p) {
		return squares.get(p);
	}

	public List<AbstractMap> getMapsCollection() {
		return mapsList;
	}

	public List<AbstractAlgo> getAlgosCollection() {
		return algosList;
	}

	public synchronized void nextStep() {
		stepCounter++;
		mainFrame.getControlPanel().updateCounter(stepCounter);
	}

	public synchronized int getTimerValue() {
		switch (timerValue) {
		case E_0MS:
			return 0;
		case E_100MS:
			return 100;
		case E_500MS:
			return 500;
		case E_50MS:
		default:
			return 50;
		}
	}

	// ********************************************//
	// ***************** Controls *****************//
	// ********************************************//
	public void drawPath(LinkedList<AbstractFloor> path, Color color) {
		for (AbstractFloor square : path) {
			square.setBackground(color);
			square.repaint();
		}
	}

	public void initIHM() {
		if (mainFrame == null) {
			mainFrame = new MainFrame();
			mainFrame.setVisible(false);
		}
		// Get first algo to run
		runningAlgo = mainFrame.getControlPanel().getSelectedAlgo();
	}

	public void start() {
		log.info("start");
		runningAlgo.stopRunning();
		try {
			log.info("Wait for thread end");
			// Thread.sleep(1000);
			if (algoThread != null)
				algoThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		mainFrame.setVisible(false);

		// Reinit IHM Counter
		stepCounter = 0;
		mainFrame.getControlPanel().updateCounter(stepCounter);

		// Map Regeneration
		AbstractMap mapItem = mainFrame.getControlPanel().getSelectedMap();
		GridPanel map = loadMap(mapItem);

		// Identify start & end point on the map
		startPoint.setBackground(Color.RED);
		endPoint.setBackground(Color.PINK);

		mainFrame.setMap(map);

		// Algo Regeneration
		runningAlgo = mainFrame.getControlPanel().getSelectedAlgo();

		mainFrame.setVisible(true);
		algoThread = new Thread(runningAlgo);
		algoThread.start();
		log.info("run thread");
	}

	// ********************************************//
	// ***************** Private ******************//
	// ********************************************//
	private GridPanel loadMap(AbstractMap Map) {
		GridPanel panel = new GridPanel(Map.getWidth(), Map.getHeight());
		AbstractFloor pan;

		for (int y = 0; y < Map.getHeight(); y++) {
			for (int x = 0; x < Map.getWidth(); x++) {
				Point p = new Point(x, y);
				int value = (Map.getMap())[y][x];

				if (value == Map.getCodeEnd()) {
					pan = new RockFloor();
					endPoint = pan;
				} else if (value == Map.getCodeStart()) {
					pan = new RockFloor();
					startPoint = pan;
				} else if (value == Map.getCodeRock()) {
					pan = new RockFloor();
				} else if (value == Map.getCodeWall()) {
					pan = new Wall();
				} else {
					log.error("Unknown map Code");
					return null;
				}

				pan.setCoordinates(p);
				panel.add(pan);
				squares.put(p, pan);
			}
		}
		return panel;
	}

	private void initMapsList() {
		mapsList = new ArrayList<>();
		mapsList.add(new Map2());
		mapsList.add(new Map1());
	}

	private void initAlgosList() {
		algosList = new ArrayList<>();
		algosList.add(new BFS());
		algosList.add(new AStar());
	}

}
