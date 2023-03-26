package vrmaster_user;

public class Customer extends User {

	
	public Customer(PaymentInfo payment, String email) {
		this.payment = payment;
		this.email = email;
	}
	@Override
	Boolean pay() {
		// TODO Auto-generated method stub
		return true;
	}

}
