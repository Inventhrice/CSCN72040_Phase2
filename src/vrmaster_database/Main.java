package vrmaster_database;

import java.awt.EventQueue;
import vrmaster_gui.PaymentInfo_GUI;
import vrmaster_user.*;

public class Main {
	public static void main(String[] args) {
		Database db = new Database();
		Customer testCus1 = new Customer(new PaymentInfo("1112 2222 3332 4442", 108), "test@domainname.ca");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Homepage(db);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
