package vrmaster_gui;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Choice;

public class BookingPage1 extends Window{
	
	/**
	 * Create the application.
	 */
	public BookingPage1() {
		initHeader("VR Master - Book a Station", new Dimension(150, 10));
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
		
		JLabel chooseProvince = new JLabel("Choose your province:");
		bodyPanel.add(chooseProvince);
		
		ArrayList<String> listProvinces = new ArrayList<String>();
		
		listProvinces.add("Choose province...");
		listProvinces.add("Alberta");
		listProvinces.add("Alberta");
		listProvinces.add("Manitoba");
		listProvinces.add("New Brunswick");	
		listProvinces.add("Newfoundland and Labrador");
		listProvinces.add("Northwest Territories");
		listProvinces.add("Nova Scotia");
		listProvinces.add("Nunavut");
		listProvinces.add("Ontario");
		listProvinces.add("Prince Edward Island");
		listProvinces.add("Quebec");
		listProvinces.add("Saskatchewan");
		listProvinces.add("Yukon");
		
		Choice provinceChoice= new Choice();
		
		bodyPanel.add(provinceChoice);
		
		JLabel chooseCity = new JLabel("Choose your city: ");
		bodyPanel.add(chooseCity);
		
		Choice cityChoice = new Choice();
		provinceChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(provinceChoice.getSelectedItem() == "Ontario") {
					cityChoice.add("Choose city...");
					cityChoice.add("Guelph");
					cityChoice.add("Kitchener");
					cityChoice.add("Waterloo");
				}
				else {
					cityChoice.removeAll();
					cityChoice.add("Choose city...");
				}
			}
		});
		bodyPanel.add(cityChoice);
		
		JLabel chooseComp = new JLabel("Choose the company:");
		bodyPanel.add(chooseComp);
		
		Choice compChoice = new Choice();
		cityChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(cityChoice.getSelectedItem() == "Guelph") {
					compChoice.add("Choose arcade...");
					compChoice.add("Ctrl-V");
				}
				else {
					compChoice.removeAll();
					compChoice.add("Choose arcade...");
				}
			}
		});
		bodyPanel.add(compChoice);
		
		
		
		JButton proceedButton = new JButton("Continue");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(provinceChoice.getSelectedItem() == "Ontario" && 
							cityChoice.getSelectedItem() == "Guelph" &&
							compChoice.getSelectedItem() == "Ctrl-V") {
						frame.setVisible(false);
						new BookingPage2();
					}
				}
		});
		bodyPanel.add(proceedButton);
	}
}
