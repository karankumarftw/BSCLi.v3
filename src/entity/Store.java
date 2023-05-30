package entity;

public class Store {
	private String storeName;
	private Long phoneNumber;
	private String address;
	private String gstNumber;

	public Store(String name, Long phoneNumber, String address, String gstNumber) {
		setStoreName(name);
		setPhoneNumber(phoneNumber);
		setAddress(address);
		setGstNumber(gstNumber);
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
}
