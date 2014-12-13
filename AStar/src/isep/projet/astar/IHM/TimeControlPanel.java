package isep.projet.astar.IHM;

import isep.projet.astar.Controler.GridControler;
import isep.projet.astar.Data.Constants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class TimeControlPanel extends JPanel {

	private JButton startPauseButton;
	private ImageIcon startIcon;
	private ImageIcon pauseIcon;
	private JButton stopButton;
	private JSlider speedSlider;

	public TimeControlPanel() {
		startIcon = new ImageIcon("play.png");
		pauseIcon = new ImageIcon("pause.png");
		startPauseButton = new JButton(startIcon);
		stopButton = new JButton(new ImageIcon("stop.png"));
		speedSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 4, 2);

		setMaximumSize(new Dimension(Constants.CONTROL_PANEL_WIDTH, 100));
		setRequestFocusEnabled(false);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		startPauseButton.setBackground(Color.WHITE);
		startPauseButton.setFocusable(false);
		startPauseButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		startPauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (startPauseButton.getIcon().equals(startIcon)) {
					startPauseButton.setIcon(pauseIcon);
					GridControler.getInstance().start();
				} else {
					startPauseButton.setIcon(startIcon);
					GridControler.getInstance().pause();
				}
			}
		});

		stopButton.setBackground(Color.WHITE);
		stopButton.setFocusable(false);
		stopButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
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

		speedSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
		speedSlider.setPaintTicks(true);

		JPanel buttons = new JPanel();

		buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
		buttons.add(Box.createRigidArea(new Dimension(15, 0)));
		buttons.add(startPauseButton);
		buttons.add(Box.createHorizontalGlue());
		buttons.add(stopButton);
		buttons.add(Box.createRigidArea(new Dimension(15, 0)));
		buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(buttons);
		add(speedSlider);

		setVisible(true);
	}

}
