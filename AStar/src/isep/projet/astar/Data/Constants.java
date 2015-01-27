package isep.projet.astar.Data;

public class Constants {

	public static final int SQUARE_SIDE = 20;

	public static final int MAIN_FRAME_HEIGHT = 700;
	public static final int MAIN_FRAME_WIDTH = 850;

	public static final int CONTROL_PANEL_WIDTH = 200;

	public static final int MAIN_FRAME_MIN_HEIGHT = SQUARE_SIDE * 20;
	public static final int MAIN_FRAME_MIN_WIDTH = SQUARE_SIDE * 20
			+ CONTROL_PANEL_WIDTH;

	public static enum MAPS_ID {
		EmptyMap, Forest, Desert, Maze
	};

	public static enum ALGOS_ID {
		BFS, DIJKSTRA, GREEDYBFS, ASTAR
	};
}
