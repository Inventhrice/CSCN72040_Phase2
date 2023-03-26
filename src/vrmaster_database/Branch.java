package vrmaster_database;

import java.util.ArrayList;

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
		if(timetable.contains(toAdd)) return false;
		else {
			timetable.add(toAdd);
			return true;
		}
		
	}
	
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
