package isep.projet.astar.Controler;

import isep.projet.astar.Data.Map1;
import isep.projet.astar.IHM.AbstractFloor;
import isep.projet.astar.IHM.ForestFloor;
import isep.projet.astar.IHM.GridPanel;
import isep.projet.astar.IHM.MainFrame;
import isep.projet.astar.IHM.RockFloor;
import isep.projet.astar.IHM.SandFloor;
import isep.projet.astar.IHM.Wall;
import isep.projet.astar.IHM.WaterFloor;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class GridControler {

	private static final Logger log = Logger.getLogger(GridControler.class);
	private static GridControler instance;
	private MainFrame mainFrame;
	private GridPanel map;
	private Map<Point, AbstractFloor> squares;
	private AbstractFloor startPoint;
	private AbstractFloor endPoint;

	private GridControler() {
		squares = new HashMap<>();
		mainFrame = new MainFrame();
		mainFrame.setVisible(false);
	}

	public static GridControler getInstance() {
		if (instance == null) {
			instance = new GridControler();
		}
		return instance;
	}

	public Map<Point, AbstractFloor> getCases() {
		return squares;
	}

	public AbstractFloor getStartPoint() {
		return startPoint;
	}

	public AbstractFloor getEndPoint() {
		return endPoint;
	}

	public AbstractFloor getSquareAt(Point p) {
		return squares.get(p);
	}

	public void start() {
		mainFrame.setMap(map);
		mainFrame.setVisible(true);
	}

	public void chooseMap(int mapNum) {
		switch (mapNum) {
		case 0:
			map = loadMap1();
			break;
		default:
			log.error("Unkown Map Number");
			return;
		}
		// Identify start & end point on the map
		startPoint.setBackground(Color.red);
		endPoint.setBackground(Color.PINK);
	}

	private GridPanel loadMap1() {
		GridPanel panel = new GridPanel(Map1.WIDTH, Map1.HEIGHT);
		AbstractFloor pan;
		for (int x = 0; x < Map1.WIDTH; x++) {
			for (int y = 0; y < Map1.WIDTH; y++) {
				Point p = new Point(x, y);

				switch (Map1.map[x][y]) {
				case Map1.CODE_END:
					pan = new RockFloor();
					endPoint = pan;
					break;
				case Map1.CODE_START:
					pan = new RockFloor();
					startPoint = pan;
					break;
				case Map1.CODE_ROCK:
					pan = new RockFloor();
					break;
				case Map1.CODE_WALL:
					pan = new Wall();
					break;
				default:
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

	// On pourra remplacer ca par lecture dans un fichier ou dans un tableau ou
	// jsais pas
	/*
	 * private GridPanel loadMap2() { GridPanel panel = new
	 * GridPanel(Map1.WIDTH, Map1.HEIGHT);
	 * 
	 * int x = 0, y = 0; AbstractFloor pan; for (int i = 0; i < (Map1.WIDTH *
	 * Map1.HEIGHT); i++) { Point p = new Point(x, y);
	 * 
	 * if ((y == 1 && x == 0) || (y == 2 && x == 0)) { pan = new WaterFloor(); }
	 * else if (x == 1 && y == 2) { pan = new ForestFloor(); } else if (y == 0)
	 * { pan = new Wall(); } else if (y == 6) { pan = new SandFloor(); } else {
	 * pan = new RockFloor(); } pan.setCoordinates(p); panel.add(pan);
	 * squares.put(p, pan); if (x == 29) { x = 0; y++; } else { x++; } }
	 * startPoint = squares.get(new Point(1,1)); endPoint = squares.get(new
	 * Point(20,20)); return panel; }
	 */
}
