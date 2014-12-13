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
	private int stepCounter;
	private boolean isPaused;
	private int timerValue;

	private GridControler() {
		initMapsList();
		initAlgosList();
		squares = new HashMap<>();
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
		return timerValue;
	}

	// ********************************************//
	// ***************** Controls *****************//
	// ********************************************//
	public void drawPath(LinkedList<AbstractFloor> path, Color color) {
		for (AbstractFloor square : path) {
			square.setColor(color);
			square.repaint();
		}
		// Enable reset
		mainFrame.getControlPanel().reinitButtons();
	}

	public void initIHM() {
		if (mainFrame == null) {
			mainFrame = new MainFrame();
		}
		// Reinit IHM Counter
		stepCounter = 0;
		mainFrame.getControlPanel().updateCounter(stepCounter);

		// Get first algo to run
		try {
			runningAlgo = mainFrame.getControlPanel().getSelectedAlgo()
					.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		// Map Regeneration
		AbstractMap mapItem = mainFrame.getControlPanel().getSelectedMap();
		GridPanel map = loadMap(mapItem);

		// Identify start & end point on the map
		startPoint.setColor(Color.RED);
		endPoint.setColor(Color.PINK);

		mainFrame.setMap(map);
		mainFrame.setVisible(true);
		
		updateTempo();
		
	}
	
	public void updateTempo(){
		log.debug("updateTempo " + mainFrame.getControlPanel().getTempoValue());
		switch (mainFrame.getControlPanel().getTempoValue()) {
		case 4:
			timerValue =  10;
			break;
		case 3:
			timerValue = 50;
			break;
		case 1:
			timerValue = 500;
			break;
		case 0:
			timerValue = 1000;
			break;
		case 2:
		default:
			timerValue = 100;
		}
		//timerValue = 510 - (mainFrame.getControlPanel().getTempoValue() * 10);
	}

	public void stop() {
		runningAlgo.stopRunning();
		try {
			log.info("Wait for thread end");
			runningAlgo.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isPaused = false;
	}

	public void pause() {
		isPaused = true;
		runningAlgo.pauseAlgo();
	}

	public void reinit() {
		initIHM();
	}

	public void start() {
		if (isPaused) {
			log.info("restart");
			runningAlgo.resumeAlgo();
			isPaused = false;
		} else {
			log.info("start");
			runningAlgo.start();
		}
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
