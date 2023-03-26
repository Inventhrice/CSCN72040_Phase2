package vrmaster_gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import vrmaster_database.Database;

import java.awt.Dimension;

public class PaymentInfo extends Window {

	/**
	 * Create the application.
	 */
	public PaymentInfo(Database db) {
		initHeader("VR Master - About", new Dimension(200, 10), db);
		initialize();
		initFinal();	
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		JPanel bodyPanel = new JPanel();
		frame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		bodyPanel.add(newTextBox("VR Master is a way for users to book a session with any VR Arcade in Canada! Currently we only have ties with Ctrl-V for their Guelph, ON branch, however in time we will expand to offer more options. Please bear with us as we grow."));
	}

}
