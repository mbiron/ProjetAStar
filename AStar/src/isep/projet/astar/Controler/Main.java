package isep.projet.astar.Controler;

import isep.projet.astar.Algo.BFS;
import isep.projet.astar.IHM.AbstractFloor;

import java.awt.Color;
import java.util.LinkedList;


public class Main {

	public static void main(String[] args) {
		GridControler controler = GridControler.getInstance();
		controler.chooseMap(1); // Avec ca on pourra faire une ptite ihm pour choisir la map et pourquoi pas l'algo
		controler.start();
		
		LinkedList<AbstractFloor> path = BFS.algo(controler.getStartPoint(),controler.getEndPoint());
		controler.drawPath(path, Color.CYAN);
	}

}
