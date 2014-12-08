package isep.projet.astar.IHM;

import isep.projet.astar.Controler.GridControler;
import isep.projet.astar.Data.Constants;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
		maps = new JComboBox<>(getMapList());
		algos = new JComboBox<>(getAlgoList());

		maps.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ComboBoxItem mapItem = (ComboBoxItem) maps.getSelectedItem();
				log.info("listener");
				GridControler.getInstance().chooseMap(mapItem.Id);
				GridControler.getInstance().start();
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

	private Vector<ComboBoxItem> getMapList() {
		Vector<ComboBoxItem> mapsItems = new Vector<>();
		for (int i = 0; i < Constants.MAP_NAMES.length; i++) {
			mapsItems.add(new ComboBoxItem(i, Constants.MAP_NAMES[i]));
		}
		return mapsItems;
	}

	private Vector<ComboBoxItem> getAlgoList() {
		Vector<ComboBoxItem> algosItems = new Vector<>();
		for (int i = 0; i < Constants.ALGO_NAMES.length; i++) {
			algosItems.add(new ComboBoxItem(i, Constants.ALGO_NAMES[i]));
		}
		return algosItems;
	}

}
