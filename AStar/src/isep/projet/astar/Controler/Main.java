package isep.projet.astar.Controler;

import isep.projet.astar.Algo.AbstractAlgo;
import isep.projet.astar.Algo.BFS;
import isep.projet.astar.Data.Constants.MAPS_ID;
import isep.projet.astar.IHM.AbstractFloor;

import java.awt.Color;
import java.util.LinkedList;


public class Main {

	public static void main(String[] args) {
		GridControler controler = GridControler.getInstance();
		controler.initIHM();
		controler.start();
		
		//AbstractAlgo algo = new BFS();
		//LinkedList<AbstractFloor> path = algo.compute(controler.getStartPoint(),controler.getEndPoint());
		//controler.drawPath(path, Color.CYAN);
	}

}
