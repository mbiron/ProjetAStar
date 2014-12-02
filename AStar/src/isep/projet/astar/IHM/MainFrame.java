package isep.projet.astar.IHM;

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
	private GridPanel gridPanel;

	public MainFrame() throws HeadlessException {
		gridPanel = new GridPanel();
		
		this.add(gridPanel);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(700, 700));

		
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
