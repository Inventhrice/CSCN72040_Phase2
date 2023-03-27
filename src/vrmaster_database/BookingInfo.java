package vrmaster_database;
import java.time.LocalDateTime;

import vrmaster_station.Bookable;
import vrmaster_user.User;

public class BookingInfo{
	private double price;
	private LocalDateTime bookingDateTime;
	private Bookable room;
	private User user;
	
	public BookingInfo() {
		price = 0;
		bookingDateTime = null;
		room = null;
		user = null;
	}
	
	public BookingInfo(double price, Bookable newResource, User newUser) {
		this.price = price;
		bookingDateTime = null;
		room = newResource;
		user = newUser;
	}
	
	public void displayInfo() {
		System.out.println(price + ", " + bookingDateTime);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User bookedBy) {
		this.user = bookedBy;
	}

	public Bookable getRoom() {
		return room;
	}

	public void setRoom(Bookable book) {
		this.room = book;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof BookingInfo) {
			BookingInfo b = (BookingInfo) o;
			return this.price == b.getPrice() && this.bookingDateTime == b.getBookingDateTime() &&
				user.equals(b.getUser()) && room.equals(b.getRoom());
		}
		else return false;
	}
}
