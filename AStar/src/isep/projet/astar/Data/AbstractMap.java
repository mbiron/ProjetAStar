package isep.projet.astar.Data;

public abstract class AbstractMap {

	private final int CODE_START = 91;
	private final int CODE_END = 115;
	private final int CODE_WALL = 50;
	private final int CODE_ROCK = 49;
	private final int CODE_FOREST = 17;

	public abstract int getHeight();

	public abstract int getWidth();

	public int getCodeStart() {
		return CODE_START;
	}

	public int getCodeEnd() {
		return CODE_END;
	}

	public int getCodeWall() {
		return CODE_WALL;
	}

	public int getCodeRock() {
		return CODE_ROCK;
	}

	public int getCodeForest() {
		return CODE_FOREST;
	}

	public abstract int[][] getMap();

	public abstract String getLabel();

	public abstract int getId();

	public String toString() {
		return getLabel();
	}

}
