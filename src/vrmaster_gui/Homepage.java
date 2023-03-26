package vrmaster_gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends Window {
	
	/**
	 * Create the application.
	 */
	public Homepage() {
		initHeader("VR Master - Home", new Dimension(200, 10));
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
		
		JButton bookButton = new JButton("Book a station");
		bookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new BookingPage1();
			}
		});
		bodyPanel.add(bookButton);
		
		JButton aboutButton = new JButton("About");
		aboutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new About();
			}
		});
		bodyPanel.add(aboutButton);
		
		JButton Rates = new JButton("Rates");
		Rates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Rates();
			}
		});
		bodyPanel.add(Rates);
		
	}

}
