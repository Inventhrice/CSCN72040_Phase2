package vrmaster_database;

import java.util.ArrayList;

import vrmaster_user.Employee;
import vrmaster_user.EmployeeDiscount;
import vrmaster_user.PaymentInfo;

public class Database {
	public ArrayList<Branch> allBranches;
	public ArrayList<Employee> allVRMasterEmployees;
	
	public Database(){
		allBranches = new ArrayList<Branch>();
		allVRMasterEmployees = new ArrayList<Employee>();
		allBranches.add(new Branch("Ctrl-V", new Address("212 Victoria Rd S Unit A", "Guelph", "Ontario", "N1E5R1")));
		
		allVRMasterEmployees.add(new Employee(new PaymentInfo("1111 2222 3333 4444", 208),
				"202@VRMaster.ca", 2, new EmployeeDiscount(20)));
		
	}
}
