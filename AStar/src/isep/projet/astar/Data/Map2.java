package isep.projet.astar.Data;

import isep.projet.astar.Data.Constants.MAPS_ID;

public class Map2 extends AbstractMap {

	private final int HEIGHT = 20;
	private final int WIDTH = 30;

	private final int CODE_START = 91;
	private final int CODE_END = 115;
	private final int CODE_WALL = 50;
	private final int CODE_ROCK = 49;

	// Générée grace a Tiled : http://www.mapeditor.org/
	//
	// Sauvegarde en mode CSV
	//
	// REGEX pour mise en forme : ,\n --> },\n
	// ^. --> {
	private final int[][] map = {
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 115, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
					50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 91, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
					49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 } };

	public int getHeight() {
		return HEIGHT;
	}

	public int getWidth() {
		return WIDTH;
	}

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

	public int[][] getMap() {
		return map;
	}

	@Override
	public String getLabel() {
		return "Empty Map";
	}

	@Override
	public int getId() {
		return MAPS_ID.EmptyMap.ordinal();
	}

}
