package vrmaster_user;

public class Employee extends User{
	int id;
	EmployeeDiscount discount;
	
	public Employee(PaymentInfo payment, String email, int id, EmployeeDiscount discount) {
		super();
		this.payment = payment;
		this.email = email;
		this.id = id;
		this.discount = discount;
	}

	@Override
	Boolean pay() {
		return true;
	}
}
