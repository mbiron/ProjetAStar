package isep.projet.astar.Data;

import isep.projet.astar.Data.Constants.MAPS_ID;

public class ForestMap extends AbstractMap {
	private final int HEIGHT = 20;
	private final int WIDTH = 35;
	
	private final int[][] map = {
{		49,49,50,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,17,17,49,49,49,49,49,49,49,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,17,17,49,17,17,17,17,17,49,17,17,17,17,17,17,49,49,49,17,17,17,17,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,17,17,49,17,17,17,17,17,49,17,17,17,17,17,49,49,17,49,17,17,17,17,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,17,17,49,17,17,17,17,17,49,17,17,17,17,17,49,17,17,49,17,17,17,17,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,17,17,49,17,17,17,17,17,49,17,17,17,17,49,49,17,17,49,17,17,17,49,49,49,49,17,17,50,49,49,49},
{		49,49,50,17,17,17,49,49,49,17,17,17,49,17,17,17,17,49,17,17,17,49,17,17,17,49,17,17,49,17,17,50,49,49,49},
{		50,50,50,17,17,17,17,17,49,17,17,17,49,17,17,17,17,49,17,17,17,49,17,17,17,49,17,17,49,17,17,50,50,50,50},
{		49,49,49,17,17,17,17,17,49,17,17,17,49,17,17,17,17,49,17,17,17,49,17,17,17,49,17,17,49,17,17,49,49,49,49},
{		49,91,49,49,49,17,17,17,49,17,17,17,49,17,17,17,17,49,49,17,17,49,17,17,17,49,17,17,49,49,49,49,115,49,49},
{		49,49,49,17,49,17,17,17,49,17,17,17,49,17,17,17,17,17,49,17,17,49,17,17,17,49,17,17,17,17,17,49,49,49,49},
{		50,50,50,17,49,17,17,17,49,17,17,17,49,17,17,17,17,17,49,17,17,49,17,17,17,49,17,17,17,17,17,50,50,50,50},
{		49,49,50,17,49,17,17,17,49,17,17,17,49,17,17,17,17,17,49,17,17,49,17,17,17,49,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,49,17,17,17,49,17,17,17,49,17,17,17,17,17,49,17,17,49,17,17,17,49,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,49,17,17,17,49,17,17,17,49,17,17,17,49,49,49,17,17,49,17,17,17,49,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,49,17,17,49,49,17,17,17,49,17,17,17,49,17,17,17,17,49,49,49,49,49,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,49,49,49,49,17,17,17,17,49,49,17,17,49,17,17,17,17,17,17,17,17,17,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,17,17,17,17,17,17,17,17,17,49,49,49,49,17,17,17,17,17,17,17,17,17,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,50,49,49,49},
{		49,49,50,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,50,49,49,49}
	};
	

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	
	public int[][] getMap() {
		return map;
	}
	
	@Override
	public String getLabel() {
		return "Forest";
	}

	@Override
	public int getId() {
		return MAPS_ID.Forest.ordinal();
	}

}