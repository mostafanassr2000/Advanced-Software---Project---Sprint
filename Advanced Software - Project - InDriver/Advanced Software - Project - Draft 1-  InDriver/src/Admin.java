
public class Admin extends ApplicationUser implements AdminAuthority{

	/*Constructor*/
	public Admin(String username, String email, String password, String mobileNumber, String keyType) {
		super(username, email, password, mobileNumber, keyType);
	}
	
	/*Methods*/
	public boolean register(Database dtb, ApplicationUser AU) {
		return accessObj.register(dtb, AU);
	}
	
	public ApplicationUser login(String username, String password, Database dtb) {
		return authorizeObj.login(username, password, dtb);
	}
	
	public void listPendingRequests(WaitingApproval wApp) {
		for(int i = 0; i < wApp.unapprovedDrivers.size(); i++) {
			System.out.println("-----------------------------------");
			System.out.println("Driver " + (i+1) + " info");
			System.out.println("Driver's Username: " + wApp.unapprovedDrivers.get(i).getUsername());
			System.out.println("Driver's Mobile Number: " + wApp.unapprovedDrivers.get(i).getMobileNumber());
			System.out.println("Driver's National ID: " + wApp.unapprovedDrivers.get(i).getNationalID());
			System.out.println("Driver's Driving License: " + wApp.unapprovedDrivers.get(i).getDrivingLicense());
			System.out.println("-----------------------------------");
			
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
	
	public void listSuspendedUsers(Suspension sus) {
		for(int i = 0; i < sus.suspendedUsers.size(); i++) {
			System.out.println("-----------------------------------");
			System.out.println("User" + (i+1) + " info");
			System.out.println("User's Username: " + sus.suspendedUsers.get(i).getUsername());
			System.out.println("User's Email: " + sus.suspendedUsers.get(i).getEmail());
			System.out.println("User's Mobile Number: " + sus.suspendedUsers.get(i).getMobileNumber());
			System.out.println("-----------------------------------");
			
		}
	}
	
	public void suspend(String username, Database dtb, Suspension sus) {
		for(int i = 0; i < dtb.applicationUsers.size(); i++) {
			if(username.equals(dtb.applicationUsers.get(i).getUsername())) {
				sus.suspendedUsers.add(dtb.applicationUsers.get(i));	//Adding this user in the suspendedUsers list
				dtb.applicationUsers.remove(i);	//Removing this user from the database.
			}
		}
	}
	
	public void unsuspend(String username, Database dtb, Suspension sus) {
		for(int i = 0; i < sus.suspendedUsers.size(); i++) {
			if(username.equals(sus.suspendedUsers.get(i).getUsername())) {
				dtb.applicationUsers.add(sus.suspendedUsers.get(i));	//Adding this user to the database.
				sus.suspendedUsers.remove(i);	//Unsuspend this user.
			}
		}
	}
	
	public String toString() {
		return "User Name: " + getUsername() + "-----" + "Type: " + keyType(); 
	}

}
