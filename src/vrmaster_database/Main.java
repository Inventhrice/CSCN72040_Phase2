package vrmaster_database;

import java.awt.EventQueue;

import vrmaster_gui.Homepage;

public class Main {
	public static void main(String[] args) {
		Database db = new Database();
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
