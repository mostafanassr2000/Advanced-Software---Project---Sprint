
public class Driver extends ApplicationUser {
	
	/*Attributes*/
	private String drivingLicense = "";
	private String nationalID = "";
	private boolean approved = false;
	
	/*Constructor*/
	public Driver(String userName, String email, String password, String mobileNumber, String keyType, String drivingLicense, String nationalID) {
		super(userName, email, password, mobileNumber, keyType);
		this.drivingLicense = drivingLicense;
		this.nationalID = nationalID;
	}
	
	/*Methods*/
	
	public void setApproval() {
		approved = true;
	}

	public boolean isApproved() {
		return approved;
	}
	
	
	void register(Database dtb, ApplicationUser AU) {
		accessObj.register(dtb, AU);
	}
	
	void login(String username, String password, Database dtb) {
		authorizeObj.login(username, password, dtb);
	}
	
	
	/*
	public void register(Database dtb) {	//Adding this driver in the database
		
		dtb.addDriver(this);
	}*/

	
	public void login() {
		
		
	}
	
	public void test() {
		System.out.println("Success");
	}
	


	public String getKey() {
		return keyType;
	}
	
	
	public String toString() {
		return "User Name: " + getUsername() + " " + "Email: " + getEmail(); 
	}
	
	

}
