package vrmaster_gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vrmaster_database.BookingInfo;
import vrmaster_database.Branch;
import vrmaster_database.Database;
import vrmaster_iterator.Iterator;

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

		// This aggregate contains the bookings for the selected branch
		Iterator branches = db.getBranchAggregate().iterator();
        Iterator bookings = null;
        while(branches.hasNext())
        {
            bookings = ((Branch)branches.next()).getTimetable().iterator();
        }
        

		Choice roomChoice = new Choice();
		ArrayList<Integer> roomList = new ArrayList<Integer>();
		while(bookings.hasNext())
		{
			BookingInfo currBooking = (BookingInfo) bookings.next();
			Integer tempRoom = currBooking.getRoom().getId();
			if(!roomList.contains(tempRoom)) roomList.add(tempRoom);
		}

		for(int i = 0; i < roomList.size(); i++) roomChoice.add(roomList.get(i).toString());
		bodyPanel.add(roomChoice);

		// Reset the iterator
		bookings = db.allBranches.get(branchIndex).getTimetable().iterator();

		Choice timeChoice = new Choice();
		ArrayList<LocalDateTime> timeList = new ArrayList<LocalDateTime>();
		while(bookings.hasNext())
		{
			int selectedRoom = Integer.parseInt(roomChoice.getSelectedItem());
			BookingInfo currBooking = (BookingInfo) bookings.next();
			
			if(selectedRoom == currBooking.getRoom().getId() && !timeList.contains(currBooking.getBookingDateTime())) 
				timeList.add(currBooking.getBookingDateTime());
		}

		for(int i = 0; i < timeList.size(); i++) timeChoice.add(timeList.get(i).toString());
		bodyPanel.add(timeChoice);

		if(isGroup)
		{
			JLabel chooseGroupSize = new JLabel("Choose group size:");
			bodyPanel.add(chooseGroupSize);

			Choice groupSizeChoice = new Choice();
			for(int i = 0; i < MAX_GROUP_SIZE; i ++)
			{
				groupSizeChoice.add(Integer.toString(i));
			}

				// Reset the iterator
				bookings = db.allBranches.get(branchIndex).getTimetable().iterator();

			int groupSize = groupSizeChoice.getSelectedIndex();
			BookingInfo currBooking = (BookingInfo) bookings.next();
			currBooking.setPrice(groupSize * currBooking.getPrice());
		}
		
		JButton payButton = new JButton("Pay");
		bodyPanel.add(payButton);



		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
				// Reset the iterator
				Iterator bookings = db.allBranches.get(branchIndex).getTimetable().iterator();

				BookingInfo choice = new BookingInfo();
				for(int i = 0; i < branchIndex; i++)
					if(bookings.hasNext()) choice = (BookingInfo) bookings.next();

				new PaymentInfo_GUI(db, branchIndex, choice);
			}
		});
	}
}
