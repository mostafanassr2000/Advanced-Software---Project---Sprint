import java.util.ArrayList;

public class Verification implements IVerification{

	public ArrayList<Driver> unapprovedDrivers= new ArrayList<Driver>();
	
	
	/*Methods*/
	
	public void addUnapprovedDriver(Driver unapprovedDriver) {
		unapprovedDrivers.add(unapprovedDriver);
	}
	
	public boolean checkUsername(String username) {
		for(int i = 0; i < unapprovedDrivers.size(); i++) {
			String currentUsername = unapprovedDrivers.get(i).getUsername();
			if(currentUsername.equals(username)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean verifyDriver(String driverUserName, Database dtb) {
		for(int i = 0; i < unapprovedDrivers.size(); i++) {
			if(driverUserName.equals(unapprovedDrivers.get(i).getUsername())) {
				
				unapprovedDrivers.get(i).setApproval();	//Setting approval to true.
				
				dtb.applicationUsers.add(unapprovedDrivers.get(i));	//Adding the driver in the database.
				
				unapprovedDrivers.remove(i);	//Removing this driver from the unapproved drivers.
				
				return true;
			}
		}
		return false; //Driver was not found in the unapprovedDrivers list.
	}
	
	public void listPendingRequests() {
		if(unapprovedDrivers.size() == 0) {
			System.out.println("No pending requests");
			System.out.println("");
			return;
		}

		for(int i = 0; i < unapprovedDrivers.size(); i++) {
			System.out.println("-----------------------------------");
			System.out.println("Driver " + (i+1) + " info");
			System.out.println("Driver's Username: " + unapprovedDrivers.get(i).getUsername());
			System.out.println("Driver's Mobile Number: " + unapprovedDrivers.get(i).getMobileNumber());
			System.out.println("Driver's National ID: " + unapprovedDrivers.get(i).getNationalID());
			System.out.println("Driver's Driving License: " + unapprovedDrivers.get(i).getDrivingLicense());
			System.out.println("-----------------------------------");
			
		}
	}

}
