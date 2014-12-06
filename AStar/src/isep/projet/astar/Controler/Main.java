package isep.projet.astar.Controler;


public class Main {

	public static void main(String[] args) {
		GridControler controler = GridControler.getInstance();
		controler.chooseMap(0); // Avec ca on pourra faire une ptite ihm pour choisir la map et pourquoi pas l'algo
		controler.start();
		
		//BFS.algo(StartPoint, EndPoint);

	}

}
