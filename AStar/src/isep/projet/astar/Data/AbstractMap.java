package isep.projet.astar.Data;

/*
 * This class describes a map. 
 * A map is stored in the int[][] format in classes that extends this class
 * Maps are generated with Tiled : http://www.mapeditor.org/
 * 
 *  Saved in CSV mode
 *  REGEX pour mise en forme : 	,\n --> },\n
 *  							^.  --> {
 */
public abstract class AbstractMap {

	public static final int CODE_START = 91;
	public static final int CODE_END = 115;
	public static final int CODE_WALL = 50;
	public static final int CODE_ROCK = 49;
	public static final int CODE_FOREST = 17;
	public static final int CODE_SAND = 112;

	public abstract int getHeight();

	public abstract int getWidth();

	public abstract int[][] getMap();

	public abstract String getLabel();

	public abstract int getId();

	public String toString() {
		return getLabel();
	}

}
