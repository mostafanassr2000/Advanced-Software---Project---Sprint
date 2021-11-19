import java.util.ArrayList;

public class WaitingApproval {

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
	
	
}
