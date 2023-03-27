package vrmaster_user;

public class Employee extends User{
	int id;
	EmployeeDiscount discount;

	public Employee() {
		super();
		this.id = 0;
		this.discount = new EmployeeDiscount();
	}

	public Employee(PaymentInfo payment, String email, int id, EmployeeDiscount discount) {
		super();
		this.payment = payment;
		this.email = email;
		this.id = id;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeDiscount getDiscount() {
		return discount;
	}

	public void setDiscount(EmployeeDiscount discount) {
		this.discount = discount;
	}

	@Override
	public PaymentInfo getPayment() {
		return payment;
	}
	
	@Override
	public Boolean pay() {
		return true;
	}
	
	@Override
	public boolean equals(Object u) {
		if(u instanceof Employee) return this.id == ((Employee) u).getId();
		else return false;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

    public Employee getDemoEmployee() {
        return new Employee(new PaymentInfo("1111 2222 3333 4444", 208), "202@VRMaster.ca", 2, new EmployeeDiscount(20));
    }
}
