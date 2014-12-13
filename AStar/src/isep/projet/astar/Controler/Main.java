package isep.projet.astar.Controler;



public class Main {

	public static void main(String[] args) {
		GridControler controler = GridControler.getInstance();
		controler.initIHM();
		//controler.start();
		
		//AbstractAlgo algo = new BFS();
		//LinkedList<AbstractFloor> path = algo.compute(controler.getStartPoint(),controler.getEndPoint());
		//controler.drawPath(path, Color.CYAN);
	}

}
