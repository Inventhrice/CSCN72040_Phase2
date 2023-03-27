package vrmaster_user;

public class EmployeeDiscount implements Discount{
	double discount;

	public EmployeeDiscount() {
		this.discount = 0;
	}

	public EmployeeDiscount(double discount)
	{
		this.discount = discount;
	}

	@Override
	public double applyDiscount(double d) {
		double ModPrice = d*discount;
		ModPrice = d - ModPrice;
		return ModPrice;
	}

	@Override
	public void setDicount(double d) {
		discount = d;
	}
}
