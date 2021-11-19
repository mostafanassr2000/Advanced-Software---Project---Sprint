
public class Admin extends ApplicationUser{

	/*Constructor*/
	public Admin(String userName, String email, String password, String mobileNumber, String keyType) {
		super(userName, email, password, mobileNumber, keyType);
	}
	
	/*Methods*/
	void register(Database dtb, ApplicationUser AU) {
		accessObj.register(dtb, AU);
	}
	
	void login(String username, String password, Database dtb) {
		authorizeObj.login(username, password, dtb);
	}
	
	
	public void listPendingRequests(WaitingApproval wApp) {
		for(int i = 0; i < wApp.unapprovedDrivers.size(); i++) {
			System.out.println("Driver Name: " + wApp.unapprovedDrivers.get(i).getUsername());
		}
	}
	
	public void verifyDriver(String driverUserName, WaitingApproval wApp, Database dtb) {
		for(int i = 0; i < wApp.unapprovedDrivers.size(); i++) {
			if(driverUserName.equals(wApp.unapprovedDrivers.get(i).getUsername())) {
				
				wApp.unapprovedDrivers.get(i).setApproval();	//Setting approval to true.
				
				dtb.applicationUsers.add(wApp.unapprovedDrivers.get(i));	//Adding the driver in the database.
				
				wApp.unapprovedDrivers.remove(i);	//Removing this driver from the unapproved drivers.
			}
		}
	}
	
	public String getKey() {
		return keyType;
	}

	public String toString() {
		return "User Name: " + getUsername() + " " + "Email: " + getEmail(); 
	}

}
