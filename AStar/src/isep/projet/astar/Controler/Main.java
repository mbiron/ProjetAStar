package isep.projet.astar.Controler;

import java.awt.Color;
import java.util.LinkedList;

import isep.projet.astar.Algo.BFS;
import isep.projet.astar.IHM.AbstractFloor;


public class Main {

	public static void main(String[] args) {
		GridControler controler = GridControler.getInstance();
		controler.chooseMap(0); // Avec ca on pourra faire une ptite ihm pour choisir la map et pourquoi pas l'algo
		controler.start();
		
		LinkedList<AbstractFloor> path = BFS.algo(controler.getStartPoint(),controler.getEndPoint());
		for(AbstractFloor square : path){
			square.setBackground(Color.cyan);
			square.repaint();
		}
	}

}
