package isep.projet.astar.Data;

import isep.projet.astar.Data.Constants.MAPS_ID;

public abstract class AbstractMap {

	public abstract int getHeight();

	public abstract int getWidth();

	public abstract int getCodeStart();

	public abstract int getCodeEnd();

	public abstract int getCodeWall();

	public abstract int getCodeRock();

	public abstract int[][] getMap();

	public abstract String getLabel();

	public abstract MAPS_ID getId();

}
