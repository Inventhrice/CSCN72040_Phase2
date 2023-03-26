package vrmaster_database;

import java.util.ArrayList;

import vrmaster_station.Bookable;
import vrmaster_user.User;

public class Branch extends Company {
	private String companyName;
	private Address address;
	private ArrayList<BookingInfo> timetable;
	
	public Branch() {
		companyName = new String("");
		address = new Address();
		timetable = new ArrayList<BookingInfo>();
	}
	
	public Branch(String companyName, Address address) {
		this.companyName = companyName;
		this.address = address;
		timetable = new ArrayList<BookingInfo>();
	}
	
	public Branch(String companyName, Address address, ArrayList<BookingInfo> timetable) {
		this.companyName = companyName;
		this.address = address;
		this.timetable = timetable;
	}
	
	public Boolean addBooking(BookingInfo toAdd) {
		boolean temp = true;
		
		for(int i = 0; i < timetable.size(); i++) {
			
			tempBookingInfo = timetable.get(i).getBook();
			
			if(tempBookingInfo.getId() == RoomNumber) {
			
				if(tempBookingInfo.getAvailability()) {
					timetable.add(new BookingInfo(price, newResource, newUser));
					timetable.get(timetable.size()).getBook().setAvailability(false);
					timetable.get(timetable.size()).getBook().setId(RoomNumber);
				}
				
				else {
					temp = false;
				}
			}
		}
		
		return temp;
	}
	
	/*
	public ArrayList<BookingInfo> getUserBookings(User newUser) {
		
		
		return 
	}
	*/
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public ArrayList<BookingInfo> getTimetable() {
		return timetable;
	}
	
	public void setTimetable(ArrayList<BookingInfo> timetable) {
		this.timetable = timetable;
	}
}
