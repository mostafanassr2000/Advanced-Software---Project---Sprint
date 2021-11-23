
public class Admin extends ApplicationUser implements IAdmin{

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
	
	public boolean verifyDriver(String driverUserName, Database dtb) {
		return verificationObj.verifyDriver(driverUserName, dtb);
	}
	
	public void listSuspendedUsers() {
		suspensionObj.listSuspendedUsers();
	}
	
	public boolean suspend(String un, Database dtb) {
		return suspensionObj.suspend(un, dtb);
	}
	
	public boolean unsuspend(String un, Database dtb) {
		return suspensionObj.unsuspend(un, dtb);
	}
	
	public String toString() {
		return "User Name: " + getUsername() + "-----" + "Type: " + keyType(); 
	}

}
