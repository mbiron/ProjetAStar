package isep.projet.astar.IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.apache.log4j.Logger;

/**
 * This panel represent the grid made of different kind of panels (= different
 * movement cost)
 * 
 * @author maxime
 *
 */
public class GridPanel extends JPanel {

	List<AbstractFloorPanel> cases;
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GridPanel.class);

	public GridPanel() {
		this.setPreferredSize(new java.awt.Dimension(600, 600));
		this.setRequestFocusEnabled(false);
		this.setLayout(new GridLayout(30, 30));

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		this.setBorder(whiteline);

		cases = new ArrayList<AbstractFloorPanel>();
		loadMap1();
		this.setVisible(true);
		log.info("coucou");
	}

	public void loadMap1() {
		int x = 0, y = 0;
		AbstractFloorPanel pan;
		for (int i = 0; i < 900; i++) {
			if (x > 30) {
				x = 0;
				y++;
			} else {
				x++;
			}
			pan = new RockFloor();
			pan.setLocation(new Point(x, y));
			this.add(pan);
			cases.add(pan);

		}
	}

}
