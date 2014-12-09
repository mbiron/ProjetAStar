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

	private static final Logger log = Logger.getLogger(ControlPanel.class);
	JLabel textMap;
	JLabel textAlgo;
	JComboBox<ComboBoxItem> maps;
	JComboBox<ComboBoxItem> algos;

	public ControlPanel() {
		textMap = new JLabel("Choose Map");
		textAlgo = new JLabel("Choose Algo");
		maps = new JComboBox<>();
		algos = new JComboBox<>();

		for (AbstractMap map : GridControler.getInstance().getMapsCollection()) {
			maps.addItem(new ComboBoxItem(map.getId(), map.getLabel()));
		}
		
		for (AbstractAlgo algo : GridControler.getInstance().getAlgosCollection()) {
			algos.addItem(new ComboBoxItem(algo.getId(), algo.getLabel()));
		}
		
		maps.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ComboBoxItem mapItem = (ComboBoxItem) maps.getSelectedItem();
				GridControler.getInstance().start(mapItem.Id);
			}
		});

		setMaximumSize(new java.awt.Dimension(200, Constants.MAIN_FRAME_HEIGHT));
		setRequestFocusEnabled(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		textMap.setAlignmentX(Component.CENTER_ALIGNMENT);
		textAlgo.setAlignmentX(Component.CENTER_ALIGNMENT);
		maps.setAlignmentX(Component.CENTER_ALIGNMENT);
		algos.setAlignmentX(Component.CENTER_ALIGNMENT);

		maps.setMaximumSize(new Dimension(200, 20));
		algos.setMaximumSize(new Dimension(200, 20));

		add(Box.createRigidArea(new Dimension(200, 100)));
		add(textMap);
		add(maps);
		add(Box.createRigidArea(new Dimension(200, 100)));
		add(textAlgo);
		add(algos);

		this.setVisible(true);
	}

	private class ComboBoxItem {
		public int Id;
		public String name;

		public ComboBoxItem(int id, String name) {
			this.Id = id;
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}
}
