package isep.projet.astar.IHM;

import isep.projet.astar.Data.Constants;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * This class is the main frame of the project In this frame appears the map
 * where the algorithm will be executed
 * 
 * @author maxime
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GridPanel map = null;

	public MainFrame() throws HeadlessException {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(Constants.MAIN_FRAME_SIDE, Constants.MAIN_FRAME_SIDE));

		pack();
	}

	public void setMap(GridPanel newMap) {
		if (map != null) {
			remove(map);
		}
		this.map = newMap;
		add(map);
		pack();
	}

	public static void main(String args[]) {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
}
