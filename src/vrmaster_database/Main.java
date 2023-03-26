package vrmaster_database;

import java.awt.EventQueue;
import vrmaster_gui.Homepage;
import vrmaster_user.*;
import vrmaster_station.*;

public class Main {
	public static void main(String[] args) {
		Employee testEmp1 = new Employee(new PaymentInfo("1111 2222 3333 4444", 208), "202@VRMaster.ca", 2, new EmployeeDiscount(20));
		Customer testCus1 = new Customer(new PaymentInfo("1112 2222 3332 4442", 108), "test@domainname.ca");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Homepage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
