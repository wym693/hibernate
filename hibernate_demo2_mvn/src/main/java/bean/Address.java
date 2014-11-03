package bean;

public class Address {
	
	private String address;
	private String phone;
	private String email;
	
	private StudentMain studentMain;
	
	public Address() {
	}
	
	
	
	public Address(String address, String phone, String email) {
		this.address = address;
		this.phone = phone;
		this.email = email;
	}




	public StudentMain getStudentMain() {
		return studentMain;
	}
	public void setStudentMain(StudentMain studentMain) {
		this.studentMain = studentMain;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	 

}
