
public class Admin extends ApplicationUser{

	/*Attributes*/
	ISuspension suspensionObj;
	IVerification verificationObj;
	
	/*Constructor*/
	public Admin(String username, String email, String password, String mobileNumber, String keyType) {
		super(username, email, password, mobileNumber, keyType);
	}
	
	/*Methods*/
	
	public void setSuspension(ISuspension suspensionObj) {
		this.suspensionObj = suspensionObj;
	}
	
	public void setVerification(IVerification verificationObj) {
		this.verificationObj = verificationObj;
	}
	
	public void listPendingRequests() {
		verificationObj.listPendingRequests();
	}
	
	public void verifyDriver(String driverUserName, Database dtb) {
		verificationObj.verifyDriver(driverUserName, dtb);
	}
	
	public void listSuspendedUsers() {
		suspensionObj.listSuspendedUsers();
	}
	
	public void suspend(String un, Database dtb) {
		suspensionObj.suspend(un, dtb);
	}
	
	public void unsuspend(String un, Database dtb) {
		suspensionObj.unsuspend(un, dtb);
	}
	
	
	
	
	public String toString() {
		return "User Name: " + getUsername() + "-----" + "Type: " + keyType(); 
	}

}
