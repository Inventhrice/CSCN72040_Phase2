package vrmaster_database;

import java.awt.EventQueue;
import java.util.Scanner;

import vrmaster_fileio.FileIODatabase;
import vrmaster_gui.Homepage;

public class Main {
	public static void main(String[] args) {
		Scanner inputScan = new Scanner(System.in);
		// Prmompt user if they would like to use a file or not
		System.out.println("Would you like to use a file? (y/n)");
		String input = inputScan.nextLine();

		Database db = null;

		// If they do, create a new database object with the file
		if(input.equals("y")) {
			FileIODatabase file = new FileIODatabase();
			db = file.readFromFile();
		}
		else if(input.equals("n")) {
			db = new Database();
		}
		else {
			System.out.println("Invalid input. Exiting program.");
			System.exit(0);
		}

		Database demo = db;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Homepage(demo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
