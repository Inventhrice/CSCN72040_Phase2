package vrmaster_gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vrmaster_database.BookingInfo;
import vrmaster_database.Database;
import vrmaster_user.PaymentInfo;

import java.awt.Dimension;

public class BookingPage3 extends Window {
	private final Integer MAX_GROUP_SIZE = 10;
	private	boolean isGroup;

	/**
	 * Create the application.
	 */
	public BookingPage3(boolean isGroup, Database db, int branchIndex) {
		initHeader("VR Master - Booking", new Dimension(200, 10), db);
		this.isGroup = isGroup;
		initialize(db, branchIndex);
		initFinal();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Database db, int branchIndex) {
		JPanel bodyPanel = new JPanel();
		frame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
		
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.X_AXIS));
		
		JLabel chooseDate = new JLabel("Choose date of booking:");
		bodyPanel.add(chooseDate);
		
		Choice timeChoice = new Choice();
		int timetableSize = db.allBranches.get(branchIndex).getTimetable().size();
		for(int i = 0; i < timetableSize; i++)
		{
			timeChoice.add(db.allBranches.get(branchIndex).getTimetable().get(i).getBookingDateTime().toString());
		}

		if(isGroup)
		{
			JLabel chooseGroupSize = new JLabel("Choose group size:");
			bodyPanel.add(chooseGroupSize);

			Choice groupSizeChoice = new Choice();
			for(int i = 0; i < MAX_GROUP_SIZE; i ++)
			{
				groupSizeChoice.add(Integer.toString(i));
			}

			int groupSize = groupSizeChoice.getSelectedIndex();
		}

		// for(int i = 9; i <= 16; i++) for(int j = 0; j < 2; j++) timeChoice.add(i + ":" + ((j % 2 == 0) ? "00" : "30")); 
		// bodyPanel.add(timeChoice);
		
		JButton payButton = new JButton("Pay");
		bodyPanel.add(payButton);

		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BookingInfo choice = db.allBranches.get(branchIndex).getTimetable().get(timeChoice.getSelectedIndex());
				new PaymentInfo_GUI(db, branchIndex, choice);
			}
		});
	}
}
