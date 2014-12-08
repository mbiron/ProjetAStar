package isep.projet.astar.IHM;

import isep.projet.astar.Data.Constants;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private ControlPanel controlPanel;

	public MainFrame() throws HeadlessException {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(new Dimension(Constants.MAIN_FRAME_WIDTH, Constants.MAIN_FRAME_HEIGHT));
		controlPanel = new ControlPanel();
		getContentPane().add(controlPanel,BorderLayout.CENTER);
		
		pack();
	}

	public void setMap(GridPanel newMap) {
		if (map != null) {
			remove(map);
		}
		this.map = newMap;
		getContentPane().add(map,BorderLayout.LINE_START);
		//add(map);
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
