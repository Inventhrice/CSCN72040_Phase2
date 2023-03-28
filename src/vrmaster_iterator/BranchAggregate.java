package vrmaster_iterator;

import java.util.ArrayList;

import vrmaster_database.Branch;

public class BranchAggregate implements Aggregate{
    private ArrayList<Branch> branches;

    private class BranchIterator implements Iterator {
        private ArrayList<Branch> branches;
        private int index;

        public BranchIterator(BranchAggregate newBranchAggregate) {
            this.branches = newBranchAggregate.getBranches();
        }

        @Override
        public boolean hasNext() {
            return index < branches.size();
        }

        @Override
        public Object next() {
            if(hasNext()) return branches.get(index++);
            else return null;
        }
    }
    
    public BranchAggregate() {
    	branches = new ArrayList<Branch>();
    }
    
    @Override
    public Iterator iterator() {
        return new BranchIterator(this);
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> newBranches) {
        this.branches = newBranches;
    }

    public void addBranch(Branch toAdd) {
        branches.add(toAdd);
    }

    public static BranchAggregate getDemoBranchAggregate() {
        BranchAggregate demoBranchAggregate = new BranchAggregate();
        demoBranchAggregate.addBranch(Branch.getDemoBranch());
        return demoBranchAggregate;
    }
}
