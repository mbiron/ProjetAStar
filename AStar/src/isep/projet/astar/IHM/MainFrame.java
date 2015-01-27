package isep.projet.astar.IHM;

import isep.projet.astar.Data.Constants;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * This class is the main frame of the project 
 * In this frame appears the map where the algorithm will be executed and the control panel
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
		setSize(new Dimension(Constants.MAIN_FRAME_WIDTH,
				Constants.MAIN_FRAME_HEIGHT));
		setMinimumSize(new Dimension(Constants.MAIN_FRAME_MIN_WIDTH,
				Constants.MAIN_FRAME_MIN_HEIGHT));
		controlPanel = new ControlPanel();
		getContentPane().add(new JPanel(), BorderLayout.LINE_START);
		getContentPane().add(controlPanel, BorderLayout.LINE_END);

		pack();
	}

	public void setMap(GridPanel newMap) {
		if (map != null) {
			remove(map);
		}
		this.map = newMap;
		getContentPane().add(map, BorderLayout.CENTER);
		pack();
	}

	public ControlPanel getControlPanel() {
		return controlPanel;
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
