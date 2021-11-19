
public class Register implements IAccess {
	Database dtb;
	

	@Override
	public void register(Database dtb, ApplicationUser AU) {
		
		this.dtb = dtb;
		dtb.applicationUsers.add(AU);	//Adding the user to the database.
		
	}
	
}
