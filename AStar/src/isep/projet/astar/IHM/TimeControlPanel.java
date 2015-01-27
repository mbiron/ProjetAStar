package isep.projet.astar.IHM;

import isep.projet.astar.Controler.GridControler;
import isep.projet.astar.Data.Constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * This panel is a part of the control panel
 * It allows to start, stop, pause and modify speed of the algorithm
 */
public class TimeControlPanel extends JPanel {

	private JButton startPauseButton;
	private ImageIcon startIcon;
	private ImageIcon pauseIcon;
	private ImageIcon restartIcon;
	private JButton stopButton;
	private JSlider speedSlider;
	private JLabel speedLabel;

	public TimeControlPanel() {
		startIcon = new ImageIcon("play.png");
		pauseIcon = new ImageIcon("pause.png");
		restartIcon = new ImageIcon("Restart.png");
		startPauseButton = new JButton(startIcon);
		stopButton = new JButton(new ImageIcon("stop.png"));
		speedLabel = new JLabel("Running speed");
		speedSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 4, 2);

		setMaximumSize(new Dimension(Constants.CONTROL_PANEL_WIDTH, 100));
		setRequestFocusEnabled(false);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		startPauseButton.setBackground(Color.WHITE);
		startPauseButton.setFocusable(false);
		startPauseButton.setAlignmentX(LEFT_ALIGNMENT);
		startPauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (startPauseButton.getIcon().equals(startIcon)) {
					startPauseButton.setIcon(pauseIcon);
					GridControler.getInstance().start();
				} else if (startPauseButton.getIcon().equals(pauseIcon)) {
					startPauseButton.setIcon(startIcon);
					GridControler.getInstance().pause();
				} else {
					GridControler.getInstance().reinit();
					startPauseButton.setIcon(startIcon);
				}
			}
		});

		stopButton.setBackground(Color.WHITE);
		stopButton.setFocusable(false);
		stopButton.setAlignmentX(RIGHT_ALIGNMENT);
		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (startPauseButton.getIcon().equals(pauseIcon)) {
					startPauseButton.setIcon(startIcon);
				}
				GridControler.getInstance().stop();
				GridControler.getInstance().reinit();
			}
		});

		speedLabel.setAlignmentX(CENTER_ALIGNMENT);

		speedSlider.setAlignmentX(CENTER_ALIGNMENT);
		speedSlider.setMinorTickSpacing(1);
		speedSlider.setPaintTicks(true);
		speedSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				GridControler.getInstance().updateTempo();
			}
		});

		JPanel buttons = new JPanel();

		buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
		buttons.add(Box.createRigidArea(new Dimension(15, 0)));
		buttons.add(startPauseButton);
		buttons.add(Box.createHorizontalGlue());
		buttons.add(stopButton);
		buttons.add(Box.createRigidArea(new Dimension(15, 0)));
		buttons.setAlignmentX(CENTER_ALIGNMENT);

		add(buttons);
		add(Box.createRigidArea(new Dimension(0, 15)));
		add(speedLabel);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(speedSlider);

		setVisible(true);
	}

	public void resetStartButton() {
		startPauseButton.setIcon(restartIcon);
	}

	public int getTempo() {
		return speedSlider.getValue();
	}
}
