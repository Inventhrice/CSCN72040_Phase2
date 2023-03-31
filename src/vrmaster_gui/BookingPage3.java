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
		
		JLabel chooseRoomNum = new JLabel("Choose room number:");
		bodyPanel.add(chooseRoomNum);

		// This aggregate contains the bookings for the selected branch
		vrmaster_iterator.Iterator branches = db.getBranchAggregate().iterator();
		for(int i=0;i<branchIndex-1;i++) branches.next();
		Branch thisBranch = (Branch)branches.next();
		vrmaster_iterator.Iterator bookings = thisBranch.getTimetable().iterator();
        

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
		bookings = thisBranch.getTimetable().iterator();
		
		JLabel chooseDate = new JLabel("Choose date of booking:");
		bodyPanel.add(chooseDate);
		
		Choice timeChoice = new Choice();
		ArrayList<LocalDateTime> timeList = new ArrayList<LocalDateTime>();
		while(bookings.hasNext())
		{
			int selectedRoom = Integer.parseInt(roomChoice.getSelectedItem());
			BookingInfo currBooking = (BookingInfo) bookings.next();
			
			if(selectedRoom == currBooking.getRoom().getId() && !timeList.contains(currBooking.getBookingDateTime()) && currBooking.getRoom().getAvailability()) 
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
				groupSizeChoice.add(Integer.toString(i));
			bodyPanel.add(groupSizeChoice);
		}
		
		JButton payButton = new JButton("Pay");
		bodyPanel.add(payButton);

		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
				// Reset the iterator
				vrmaster_iterator.Iterator bookings = thisBranch.getTimetable().iterator();
				
				
				BookingInfo choice = (BookingInfo)bookings.next();
				while(bookings.hasNext() 
						&& choice.getRoom().getId() != Integer.parseInt(roomChoice.getSelectedItem())
						&& choice.getBookingDateTime() != LocalDateTime.parse(timeChoice.getSelectedItem())) {
					choice = (BookingInfo)bookings.next();
				}
				
				if(isGroup) {
					//sets choice price to be the number of people * default is price per one person. Have to do it in this way because 
					//this function cannot view anything out of this scope unless it is a global variable.
					choice.setPrice(Integer.parseInt(((Choice)(bodyPanel.getComponent(5))).getSelectedItem()) * choice.getPrice());
					//to whatever god is listening, i am sorry
				}
				
				new PaymentInfo_GUI(db, branchIndex, choice);
			}
		});
	}
}
