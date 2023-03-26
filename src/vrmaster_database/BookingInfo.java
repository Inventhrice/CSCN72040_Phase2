package vrmaster_database;
import java.time.LocalDateTime;

import vrmaster_station.Bookable;
import vrmaster_user.User;

public class BookingInfo{
	private int price;
	private LocalDateTime bookingDateTime;
	private Bookable resource;
	private User bookedBy;
	
	public BookingInfo() {
		price = 0;
		bookingDateTime = null;
		resource = null;
		bookedBy = null;
	}
	
	public BookingInfo(int price, Bookable newResource, User newUser) {
		this.price = price;
		bookingDateTime = null;
		resource = newResource;
		bookedBy = newUser;
	}
	
	public void displayInfo() {
		System.out.println(price + ", " + bookingDateTime);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public User getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}

	public Bookable getBook() {
		return resource;
	}

	public void setBook(Bookable book) {
		this.resource = book;
	}
	
	public boolean equals(BookingInfo b) {
		return this.price == b.getPrice() && this.bookingDateTime == b.getBookingDateTime() &&
				bookedBy.equals(b.getBookedBy()) && resource.equals(b.getBookedBy());
	}
}
