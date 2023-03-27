package vrmaster_database;

import vrmaster_iterator.BranchAggregate;
import vrmaster_iterator.EmployeeAggregate;

public class Database {
	private BranchAggregate branchAggregate;
	private EmployeeAggregate employeeAggregate;

	public Database(BranchAggregate branchAggregate, EmployeeAggregate employeeAggregate) {
		this.branchAggregate = branchAggregate;
		this.employeeAggregate = employeeAggregate;
	}

	public Database() {
		// allBranches = new ArrayList<Branch>();
		// allVRMasterEmployees = new ArrayList<Employee>();
		
		// allBranches.add(new Branch("Ctrl-V", new Address("212 Victoria Rd S Unit A", "Guelph", "Ontario", "N1E5R1")));

		// allVRMasterEmployees.add(new Employee(new PaymentInfo("1111 2222 3333 4444", 208),
		// 		"202@VRMaster.ca", 2, new EmployeeDiscount(20)));
	
		// initTimetable();
	}

	public BranchAggregate getBranchAggregate() {
		return branchAggregate;
	}

	public EmployeeAggregate getEmployeeAggregate() {
		return employeeAggregate;
	}

	public Database getDemoDatabase()
	{
		Database demoDatabase = new Database();
		demoDatabase.branchAggregate = demoDatabase.branchAggregate.getDemoBranchAggregate();
		demoDatabase.employeeAggregate = demoDatabase.employeeAggregate.getDemoEmployeeAggregate();
		return demoDatabase;
	}
}
