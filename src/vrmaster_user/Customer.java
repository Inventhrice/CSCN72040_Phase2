package vrmaster_user;

public class Customer extends User {
	public Customer(PaymentInfo payment, String email) {
		this.payment = payment;
		this.email = email;
	}
	@Override
	public Boolean pay() {
		return true;
	}
	@Override
	public PaymentInfo getPayment() {
		return payment;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public Boolean equals(User u) {
		if(u instanceof Customer) return this.email == u.getEmail();
		else return false;
	}
	
	
}
