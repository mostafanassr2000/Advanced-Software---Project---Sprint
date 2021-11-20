import java.util.ArrayList;

public class Suspension implements ISuspension{

	public ArrayList<ApplicationUser> suspendedUsers;
	
	public Suspension(){
		suspendedUsers = new ArrayList<ApplicationUser>();
	}
	
	public void listSuspendedUsers() {
		for(int i = 0; i < suspendedUsers.size(); i++) {
			System.out.println("-----------------------------------");
			System.out.println("User" + (i+1) + " info");
			System.out.println("User's Username: " + suspendedUsers.get(i).getUsername());
			System.out.println("User's Email: " + suspendedUsers.get(i).getEmail());
			System.out.println("User's Mobile Number: " + suspendedUsers.get(i).getMobileNumber());
			System.out.println("-----------------------------------");
			
		}
	}
	
	public void suspend(String username, Database dtb) {
		for(int i = 0; i < dtb.applicationUsers.size(); i++) {
			if(username.equals(dtb.applicationUsers.get(i).getUsername())) {
				suspendedUsers.add(dtb.applicationUsers.get(i));	//Adding this user in the suspendedUsers list
				dtb.applicationUsers.remove(i);	//Removing this user from the database.
			}
		}
	}
	
	public void unsuspend(String username, Database dtb) {
		for(int i = 0; i < suspendedUsers.size(); i++) {
			if(username.equals(suspendedUsers.get(i).getUsername())) {
				dtb.applicationUsers.add(suspendedUsers.get(i));	//Adding this user to the database.
				suspendedUsers.remove(i);	//Unsuspend this user.
			}
		}
	}
	

}
