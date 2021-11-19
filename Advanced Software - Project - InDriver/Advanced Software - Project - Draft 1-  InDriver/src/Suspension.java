import java.util.ArrayList;

public class Suspension {

	public ArrayList<ApplicationUser> suspendedUsers;
	
	public Suspension(){
		suspendedUsers = new ArrayList<ApplicationUser>();
	}
	
	public void suspend(ApplicationUser au) {
		suspendedUsers.add(au);
	}
	
	
}
