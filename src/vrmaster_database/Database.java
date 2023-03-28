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
		this.branchAggregate = BranchAggregate.getDemoBranchAggregate();
		this.employeeAggregate = EmployeeAggregate.getDemoEmployeeAggregate();
	}

	public BranchAggregate getBranchAggregate() {
		return branchAggregate;
	}

	public EmployeeAggregate getEmployeeAggregate() {
		return employeeAggregate;
	}
}
