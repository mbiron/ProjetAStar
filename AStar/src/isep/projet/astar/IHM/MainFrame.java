package isep.projet.astar.IHM;

import java.awt.HeadlessException;

import javax.swing.JFrame;

/**
 * This class is the main frame of the project
 * In this frame appears the map where the algorithm will be executed
 * 
 * @author maxime
 *
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() throws HeadlessException {
		this.add(new GridPanel());
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
