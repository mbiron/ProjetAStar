package isep.projet.astar.IHM;

import isep.projet.astar.Algo.AbstractAlgo;
import isep.projet.astar.Controler.GridControler;
import isep.projet.astar.Data.AbstractMap;
import isep.projet.astar.Data.Constants;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControlPanel.class);
	JLabel textMap;
	JLabel textAlgo;
	JComboBox<AbstractMap> maps;
	JComboBox<AbstractAlgo> algos;

	public ControlPanel() {
		textMap = new JLabel("Choose Map");
		textAlgo = new JLabel("Choose Algo");
		maps = new JComboBox<>();
		algos = new JComboBox<>();

		for (AbstractMap map : GridControler.getInstance().getMapsCollection()) {
			maps.addItem(map);
		}
		for (AbstractAlgo algo : GridControler.getInstance()
				.getAlgosCollection()) {
			algos.addItem(algo);
		}

		maps.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ask for restart
				GridControler.getInstance().start();
			}
		});

		algos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ask for restart
				GridControler.getInstance().start();
			}
		});

		setMinimumSize(new java.awt.Dimension(Constants.CONTROL_PANEL_WIDTH,
				Constants.MAIN_FRAME_HEIGHT));
		setRequestFocusEnabled(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		textMap.setAlignmentX(Component.CENTER_ALIGNMENT);
		textAlgo.setAlignmentX(Component.CENTER_ALIGNMENT);
		maps.setAlignmentX(Component.CENTER_ALIGNMENT);
		algos.setAlignmentX(Component.CENTER_ALIGNMENT);

		maps.setMaximumSize(new Dimension(Constants.CONTROL_PANEL_WIDTH, 20));
		algos.setMaximumSize(new Dimension(Constants.CONTROL_PANEL_WIDTH, 20));

		add(Box.createRigidArea(new Dimension(Constants.CONTROL_PANEL_WIDTH,
				100)));
		add(textMap);
		add(maps);
		add(Box.createRigidArea(new Dimension(Constants.CONTROL_PANEL_WIDTH,
				100)));
		add(textAlgo);
		add(algos);

		this.setVisible(true);
	}

	public AbstractMap getSelectedMap() {
		return (AbstractMap) maps.getSelectedItem();
	}

	public AbstractAlgo getSelectedAlgo() {
		return (AbstractAlgo) algos.getSelectedItem();
	}
}
