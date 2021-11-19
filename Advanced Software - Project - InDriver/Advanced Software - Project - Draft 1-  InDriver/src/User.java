
public class User extends ApplicationUser {

	/*Constructor*/
	public User(String userName, String email, String password, String mobileNumber, String keyType) {
		super(userName, email, password, mobileNumber, keyType);
	}

	/*Methods*/

	public boolean register(Database dtb, ApplicationUser AU) {
		return accessObj.register(dtb, AU);
	}

	public ApplicationUser login(String username, String password, Database dtb) {
		return authorizeObj.login(username, password, dtb);
	}
	
	public String toString() {
		return "User Name: " + getUsername() + "-----" + "Type: " + keyType(); 
	}

}
