import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Database implements IAccess{

	//public ArrayList<ApplicationUser> applicationUsers = new ArrayList<ApplicationUser>();
	
	public ArrayList<ApplicationUser> applicationUsers = new ArrayList<ApplicationUser>();
	public LinkedList dat;
	
	Database(){
		dat = new LinkedList();
	}
	
	void add() {
		
		
	}
	
	
	
	
	
	public ArrayList<User> users = new ArrayList<User>();
	public ArrayList<Driver> drivers = new ArrayList<Driver>();
	public ArrayList<Admin> admins = new ArrayList<Admin>();
	
	
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public void addDriver(Driver d) {
		drivers.add(d);
	}
	
	public void addAdmin(Admin a) {
		admins.add(a);
	}

	@Override
	public void addUser(ApplicationUser AU) {
		dat.add(AU);
	}

	

	
	
	
}
