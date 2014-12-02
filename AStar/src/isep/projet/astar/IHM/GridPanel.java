package isep.projet.astar.IHM;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * This panel represent the grid made of different kind of panels (= different 
 * movement cost)
 * 
 * @author maxime
 *
 */
public class GridPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridPanel() {
		this.setLayout(new GridLayout(30, 30));
	}

}
