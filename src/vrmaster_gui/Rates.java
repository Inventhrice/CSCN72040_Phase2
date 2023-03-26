package vrmaster_gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;

public class Rates extends Window{
	
	/**
	 * Create the application.
	 */
	public Rates() {
		initHeader("VR Master - Rates", new Dimension(200, 10));
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
		bodyPanel.add(newTextBox("We cannot list our ratings on this page as they vary from company to company. Please look at our bookings for more information."));
		
	}

}
