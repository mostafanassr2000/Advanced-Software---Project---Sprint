
public class Login implements IAuthorize{
	Database dtb;

	@Override
	public ApplicationUser login(String un, String pw, Database dtb) {
		this.dtb = dtb;
		
		for(int i = 0; i < dtb.applicationUsers.size(); i++) {
			String currentUsername = dtb.applicationUsers.get(i).getUsername();
			String currentPassword = dtb.applicationUsers.get(i).getPassword();
			
			if(currentUsername.equals(un) && currentPassword.equals(pw)) {
				return dtb.applicationUsers.get(i);
			}
		}
		
		return null;
	}
	
	
}
