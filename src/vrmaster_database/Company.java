package vrmaster_database;
public class Company {
	private String name;
	
	public Company() {
		name = new String("");
	}
	
	public Company(String name) {
		this.name = new String(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
