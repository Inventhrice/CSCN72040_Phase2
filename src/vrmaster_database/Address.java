package vrmaster_database;
public class Address {
	private String streetAddress;
	private String province;
	private String zipCode;
	private String city;
	
	public Address() {
		streetAddress = new String("");
		province = new String("");
		zipCode = new String("");
		setCity(new String(""));
	}
	
	public Address(String streetAddress, String province, String zipCode, String city) {
		this.streetAddress = new String(streetAddress);
		this.province = new String(province);
		this.zipCode = new String(zipCode);
		this.setCity(new String(city));
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
