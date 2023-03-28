package vrmaster_gui;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ibm.icu.text.Edits.Iterator;

import vrmaster_database.Address;
import vrmaster_database.Branch;
import vrmaster_database.Database;

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
	public BookingPage1(Database db) {
		initHeader("VR Master - Book a Station", new Dimension(150, 10), db);
		initialize(db);
		initFinal();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Database db) {
		JPanel bodyPanel = new JPanel();
		frame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		
		JLabel chooseProvince = new JLabel("Choose your province:");
		bodyPanel.add(chooseProvince);
		
		Choice provinceChoice = new Choice();
		provinceChoice.add("Choose province...");
		
		vrmaster_iterator.Iterator branchIterator = db.getBranchAggregate().iterator();
		ArrayList<String> list = new ArrayList<String>();
		Address tempAddr;
		
		while(branchIterator.hasNext()) {
			tempAddr = ((Branch) branchIterator.next()).getAddress();
			if(!list.contains(tempAddr.getProvince()))list.add(tempAddr.getProvince());
		}
		
		for(int i = 0; i < list.size(); i++) provinceChoice.add(list.get(i));
		bodyPanel.add(provinceChoice);
		
		list.clear();
		JLabel chooseCity = new JLabel("Choose your city: ");
		bodyPanel.add(chooseCity);
		
		
		Choice cityChoice = new Choice();
		provinceChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				vrmaster_iterator.Iterator branchIterator = db.getBranchAggregate().iterator();
				Address tempAddr;
				cityChoice.removeAll();
				
				while(branchIterator.hasNext()) {
					tempAddr = ((Branch) branchIterator.next()).getAddress();
					if(tempAddr.getProvince() == provinceChoice.getSelectedItem()) {
						if(!list.contains(tempAddr.getCity())) list.add(tempAddr.getCity()); 
					}
				}
				cityChoice.add("Choose city...");
				for(int i = 0; i<list.size();i++)cityChoice.add(list.get(i));
			}
		});
		bodyPanel.add(cityChoice);
		
		list.clear();

		ArrayList<String> compList = new ArrayList<String>();
		JLabel chooseComp = new JLabel("Choose the company:");
		bodyPanel.add(chooseComp);
		
		Choice compChoice = new Choice();
		cityChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				compChoice.removeAll();
				vrmaster_iterator.Iterator branchIterator = db.getBranchAggregate().iterator();
				Branch tempBranch;
				
				while(branchIterator.hasNext()) {
					tempBranch = (Branch) branchIterator.next(); 
					
					if(tempBranch.getAddress().getProvince() == provinceChoice.getSelectedItem() && 
							tempBranch.getAddress().getCity() == cityChoice.getSelectedItem()) {
						if(!compList.contains(tempBranch.getCompanyName())) compList.add(tempBranch.getCompanyName()); 
					}
				}
				
				compChoice.add("Choose arcade...");
				for(int i = 0; i < compList.size();i++) compChoice.add(compList.get(i));
			}
		});
		bodyPanel.add(compChoice);
		
		JButton proceedButton = new JButton("Continue");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				int branchIndex = 0;
				vrmaster_iterator.Iterator branchIterator = db.getBranchAggregate().iterator();
				Branch tempBranch;
				while(branchIterator.hasNext()) {
					tempBranch = (Branch) branchIterator.next();
					found =  tempBranch.getAddress().getProvince() == provinceChoice.getSelectedItem()
							&& tempBranch.getAddress().getCity() == cityChoice.getSelectedItem()
							&& tempBranch.getCompanyName() == compChoice.getSelectedItem(); 
					if(!found) branchIndex++;
				}
				frame.setVisible(false);
				new BookingPage2(db, branchIndex);
			}
		});
		bodyPanel.add(proceedButton);
	}
}
