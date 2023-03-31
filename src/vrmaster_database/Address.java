package vrmaster_database;

import java.io.Serializable;

public class Address implements Serializable{
	private String streetAddress;
	private String province;
	private String zipCode;
	private String city;
	
	public Address() {
		streetAddress = "";
		province = "";
		zipCode = "";
		setCity("");
	}
	
	public Address(String streetAddress, String city, String province, String zipCode) {
		this.streetAddress = streetAddress;
		this.province = province;
		this.zipCode = zipCode;
		this.setCity(city);
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
