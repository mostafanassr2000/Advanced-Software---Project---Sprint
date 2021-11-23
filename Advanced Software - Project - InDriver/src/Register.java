
public class Register implements IAccess {
	Database dtb;

	@Override
	public boolean register(Database dtb, ApplicationUser AU) {
		
		this.dtb = dtb;
		
		for(int i = 0; i < dtb.applicationUsers.size(); i++) {
			String currentUsername = dtb.applicationUsers.get(i).getUsername();
			if(currentUsername.equals(AU.getUsername())) {
				return false;
			}
		}
		
		if(AU instanceof Driver) {	//Driver name is available
			return true;
		}
		
		dtb.applicationUsers.add(AU);	//Adding the user to the database.
		return true;
	}
	
}
