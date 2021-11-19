import java.util.ArrayList;

public class UserDatabase implements IAccess{


	private ArrayList<User> users = new ArrayList<User>();
	
	
	@Override
	public void addUser(ApplicationUser AU) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAuthorized(ApplicationUser AU) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
