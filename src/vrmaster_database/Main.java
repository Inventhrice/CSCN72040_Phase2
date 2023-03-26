package vrmaster_database;

import java.awt.EventQueue;
import vrmaster_gui.Homepage;
import vrmaster_gui.PaymentInfo_GUI;
import vrmaster_user.*;
import vrmaster_station.*;

public class Main {
	public static void main(String[] args) {
		Database db = new Database();
		Customer testCus1 = new Customer(new PaymentInfo("1112 2222 3332 4442", 108), "test@domainname.ca");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PaymentInfo_GUI(db, 0, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
