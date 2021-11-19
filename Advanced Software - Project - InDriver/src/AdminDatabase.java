import java.util.ArrayList;

public class AdminDatabase implements IAccess{

	/*Attributes*/
	private ArrayList<Admin> admins = new ArrayList<Admin>();
	

	
	
	/*Methods*/
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
