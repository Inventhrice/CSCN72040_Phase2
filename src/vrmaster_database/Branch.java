package vrmaster_database;

import java.util.ArrayList;

import vrmaster_iterator.Timetable;

public class Branch extends Company{
	private String companyName;
	private Address address;
	private Timetable timetable;
	
	public Branch() {
		companyName = new String("");
		address = new Address();
		timetable = new Timetable();
	}
	
	public Branch(String companyName, Address address) {
		this.companyName = companyName;
		this.address = address;
		timetable = new Timetable();
	}
	
	public Branch(String companyName, Address address, ArrayList<BookingInfo> timetable) {
		this.timetable = new Timetable();
		this.companyName = companyName;
		this.address = address;
		this.timetable.setTimetable(timetable);
	}
	
	public Boolean addBooking(BookingInfo toAdd) {
		if(timetable.getTimetable().contains(toAdd)) return false;
		else {
			timetable.addBooking(toAdd);
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
	
	public Timetable getTimetable() {
		return timetable;
	}
	
	public void setTimetable(ArrayList<BookingInfo> newTimetable) {
		this.timetable.setTimetable(newTimetable);
	}

	public static Branch getDemoBranch()
	{
		String companyName = "Ctrl-V";
		Address address = new Address("212 Victoria Rd S Unit A", "Guelph", "Ontario", "N1E5R1");
		return new Branch(companyName, address, Timetable.getDemoTimetable());
	}
}
