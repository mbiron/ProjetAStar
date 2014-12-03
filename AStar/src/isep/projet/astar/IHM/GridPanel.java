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
 * This panel represents the grid made of different kind of panels (= different
 * movement cost)
 * 
 * @author maxime
 *
 */
public class GridPanel extends JPanel {

	List<AbstractFloor> cases;
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GridPanel.class);

	public GridPanel() {
		this.setPreferredSize(new java.awt.Dimension(600, 600));
		this.setRequestFocusEnabled(false);
		this.setLayout(new GridLayout(30, 30));

		Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
		this.setBorder(whiteline);

		cases = new ArrayList<AbstractFloor>();
		loadMap1();
		this.setVisible(true);
		log.info("coucou");
	}

	public void loadMap1() {
		int x = 0, y = 0;
		AbstractFloor pan;
		for (int i = 0; i < 900; i++) {
			Point p = new Point(x, y);
	
			if ( (y == 1 && x == 0) || (y == 2 && x == 0)) {
				pan = new WaterFloor();
			} else if (x == 1 && y == 2) {
				pan = new ForestFloor();
			} else if(y ==0){
				pan = new Wall();
			}else if(y ==6){
				pan = new SandFloor();
			}else {
			
				pan = new RockFloor();
			}
			pan.setLocation(p);
			this.add(pan);
			cases.add(pan);
			if (x == 29) {
				x = 0;
				y++;
			} else {
				x++;
			}
		}
	}
}
