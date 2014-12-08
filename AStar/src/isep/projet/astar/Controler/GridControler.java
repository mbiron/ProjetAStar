package isep.projet.astar.Controler;

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
import java.util.HashMap;
import java.util.LinkedList;
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

	public void drawPath(LinkedList<AbstractFloor> path , Color color ){
		for(AbstractFloor square : path){
			square.setBackground(color);
			square.repaint();
		}
	}
	
	public void start() {
		mainFrame.setMap(map);
		mainFrame.setVisible(true);
	}

	public void chooseMap(int mapNum) {
		switch (mapNum) {
		case 0:
			map = loadMap(new Map1());
			break;
		case 1:
			map = loadMap(new Map2());
			break;
		default:
			log.error("Unkown Map Number");
			return;
		}
		// Identify start & end point on the map
		startPoint.setBackground(Color.red);
		endPoint.setBackground(Color.PINK);
	}

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
}
