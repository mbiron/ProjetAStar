package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.apache.log4j.Logger;

import isep.projet.astar.Data.Constants;

/**
 * This panel represents the grid made of different kind of panels (= different
 * movement cost)
 * 
 * @author maxime
 *
 */
public class GridPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GridPanel.class);

	public GridPanel(int width, int height) {
		this.setPreferredSize(new java.awt.Dimension(width * Constants.SQUARE_SIDE,height * Constants.SQUARE_SIDE));
		this.setRequestFocusEnabled(false);
		this.setLayout(new GridLayout(width, height));

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		this.setBorder(whiteline);

		this.setVisible(true);
		
	}
}
