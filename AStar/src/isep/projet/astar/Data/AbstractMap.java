package isep.projet.astar.Data;

public abstract class AbstractMap {

	public abstract int getHeight();

	public abstract int getWidth();

	public abstract int getCodeStart();

	public abstract int getCodeEnd();

	public abstract int getCodeWall();

	public abstract int getCodeRock();

	public abstract int[][] getMap();

}
