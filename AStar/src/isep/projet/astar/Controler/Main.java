package isep.projet.astar.Controler;

public class Main {

	public static void main(String[] args) {
		// The main method only initializes the IHM. 
		// Then, the main frame became the main thread.
		GridControler controler = GridControler.getInstance();
		controler.initIHM();
	}

}
