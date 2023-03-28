package vrmaster_iterator;

import java.util.ArrayList;

import vrmaster_user.Employee;

public class EmployeeAggregate implements Aggregate {
    private ArrayList<Employee> employees;

    private class EmployeeIterator implements Iterator {
        private ArrayList<Employee> employees;
        private int index;

        public EmployeeIterator(EmployeeAggregate newEmployeeAggregate) {
            this.employees = newEmployeeAggregate.getEmployees();
        }

        @Override
        public boolean hasNext() {
            return index < employees.size();
        }

        @Override
        public Object next() {
            if(hasNext()) return employees.get(index++);
            else return null;
        }
    }
    
    public EmployeeAggregate() {
    	employees = new ArrayList<Employee>();
    }
    
    @Override
    public Iterator iterator() {
        return new EmployeeIterator(this);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> newEmployees) {
        this.employees = newEmployees;
    }

    public void addEmployee(Employee toAdd) {
        employees.add(toAdd);
    }

    public static EmployeeAggregate getDemoEmployeeAggregate() {
        EmployeeAggregate demoEmployeeAggregate = new EmployeeAggregate();
        demoEmployeeAggregate.addEmployee(Employee.getDemoEmployee());
        return demoEmployeeAggregate;
    }
}
