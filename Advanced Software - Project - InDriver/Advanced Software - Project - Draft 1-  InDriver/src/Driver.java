
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
	
	public boolean register(Database dtb, ApplicationUser AU) {
		return accessObj.register(dtb, AU);
	}
	
	public ApplicationUser login(String username, String password, Database dtb) {
		return authorizeObj.login(username, password, dtb);
	}
		
	public void setApproval() {
		approved = true;
	}

	public boolean isApproved() {
		return approved;
	}

	
	/*Getters*/
	public String getNationalID() {
		return nationalID;
	}
	
	public String getDrivingLicense() {
		return drivingLicense;
	}
	
	public String toString() {
		return "User Name: " + getUsername() + "-----" + "Type: " + keyType(); 
	}
	
	

}
