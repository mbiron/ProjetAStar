package isep.projet.astar.Controler;

import isep.projet.astar.IHM.AbstractFloor;
import isep.projet.astar.IHM.ForestFloor;
import isep.projet.astar.IHM.GridPanel;
import isep.projet.astar.IHM.MainFrame;
import isep.projet.astar.IHM.RockFloor;
import isep.projet.astar.IHM.SandFloor;
import isep.projet.astar.IHM.Wall;
import isep.projet.astar.IHM.WaterFloor;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class GridControler {

	private static final Logger log = Logger.getLogger(GridControler.class);
	private static GridControler instance;
	private static MainFrame mainFrame;
	private static GridPanel map;
	private static Map<Point, AbstractFloor> cases;
	private static AbstractFloor startPoint;
	private static AbstractFloor endPoint;
	
	private GridControler() {
		cases = new HashMap<>();
		mainFrame = new MainFrame();
		mainFrame.setVisible(false);
	}
	
	public static GridControler getInstance() {
		if (instance == null) {
			instance = new GridControler();
		}
		return instance;
	}

	public static Map<Point, AbstractFloor> getCases() {
		return cases;
	}

	public static AbstractFloor getStartPoint() {
		return startPoint;
	}

	public static AbstractFloor getEndPoint() {
		return endPoint;
	}

	public void start(){
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
		mainFrame.setMap(map);
	}

	// On pourra remplacer ca par lecture dans un fichier ou autre
	private GridPanel loadMap1() {
		GridPanel panel = new GridPanel(600, 600, 30, 30);

		int x = 0, y = 0;
		AbstractFloor pan;
		for (int i = 0; i < 900; i++) {
			Point p = new Point(x, y);

			if ((y == 1 && x == 0) || (y == 2 && x == 0)) {
				pan = new WaterFloor();
			} else if (x == 1 && y == 2) {
				pan = new ForestFloor();
			} else if (y == 0) {
				pan = new Wall();
			} else if (y == 6) {
				pan = new SandFloor();
			} else {
				pan = new RockFloor();
			}
			pan.setLocation(p);
			panel.add(pan);
			cases.put(p, pan);
			if (x == 29) {
				x = 0;
				y++;
			} else {
				x++;
			}
		}
		return panel;
	}
}
