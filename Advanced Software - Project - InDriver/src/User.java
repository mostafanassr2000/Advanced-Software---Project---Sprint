
public class User extends ApplicationUser {

	/*Constructor*/
	public User(String userName, String email, String password, String mobileNumber, String keyType) {
		super(userName, email, password, mobileNumber, keyType);
	}

	/*Methods*/

	void register(Database dtb, ApplicationUser AU) {
		accessObj.register(dtb, AU);
	}

	void login(String username, String password, Database dtb) {
		authorizeObj.login(username, password, dtb);
	}
	
	/*
	public void registerUser(User user) {
		accessObj.addUser(user);
	}*/
	
	
	public String getKey() {
		return keyType;
	}
	
	
	public String toString() {
		return "User Name: " + getUsername() + " " + "Email: " + getEmail(); 
	}

	
	
	

}
