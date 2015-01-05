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
	private JLabel textMap;
	private JLabel textAlgo;
	private JLabel counter;
	private JLabel pathSize;
	private JLabel pathCoast;
	private JComboBox<AbstractMap> maps;
	private JComboBox<AbstractAlgo> algos;
	private TimeControlPanel timeControlPanel;

	public ControlPanel() {
		textMap = new JLabel("Choose Map");
		textAlgo = new JLabel("Choose Algo");
		counter = new JLabel("Counter = " + 0);
		pathSize = new JLabel("Path Length = " + 0);
		pathCoast = new JLabel("Path Coast = " + 0);
		maps = new JComboBox<>();
		algos = new JComboBox<>();
		timeControlPanel = new TimeControlPanel();
		
		pathSize.setVisible(false);
		pathCoast.setVisible(false);
		
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
				GridControler.getInstance().stop();
				GridControler.getInstance().reinit();
			}
		});

		algos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ask for restart
				GridControler.getInstance().stop();
				GridControler.getInstance().reinit();
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
		counter.setAlignmentX(Component.CENTER_ALIGNMENT);
		pathSize.setAlignmentX(Component.CENTER_ALIGNMENT);
		pathCoast.setAlignmentX(Component.CENTER_ALIGNMENT);
		timeControlPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		maps.setMaximumSize(new Dimension(Constants.CONTROL_PANEL_WIDTH - 30, 20));
		algos.setMaximumSize(new Dimension(Constants.CONTROL_PANEL_WIDTH - 30, 20));

		add(Box.createRigidArea(new Dimension(Constants.CONTROL_PANEL_WIDTH,
				50)));
		add(textMap);
		add(maps);
		add(Box.createRigidArea(new Dimension(Constants.CONTROL_PANEL_WIDTH,
				50)));
		add(textAlgo);
		add(algos);
		add(counter);
		add(pathSize);
		add(pathCoast);
		add(Box.createRigidArea(new Dimension(Constants.CONTROL_PANEL_WIDTH,
				30)));
		add(timeControlPanel);

		setVisible(true);
	}

	public synchronized void updateCounter(int counterValue) {
		counter.setText("Counter = " + counterValue);
	}
	
	public void updatePathSize(int pathLength) {
		pathSize.setText("Path Length = " + pathLength);
		pathSize.setVisible(true);
	}
	
	public void updatePathCoast(int pathTotCoast) {
		pathCoast.setText("Path Coast = " + pathTotCoast);
		pathCoast.setVisible(true);
	}
	
	public void reinit(){
		counter.setText("Counter = " + 0);
		pathSize.setVisible(false);
		pathCoast.setVisible(false);
	}

	public AbstractMap getSelectedMap() {
		return (AbstractMap) maps.getSelectedItem();
	}
	
	public int getTempoValue(){
		return timeControlPanel.getTempo();
	}
	
	public void reinitButtons(){
		timeControlPanel.resetStartButton();
	}

	public AbstractAlgo getSelectedAlgo() {
		return (AbstractAlgo) algos.getSelectedItem();
	}
}
