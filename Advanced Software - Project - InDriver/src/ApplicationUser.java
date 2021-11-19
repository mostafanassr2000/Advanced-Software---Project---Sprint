
public abstract class ApplicationUser {
	/*Attributes*/
	protected String userName;
	protected String mobileNumber;
	protected String email;
	protected String password;
	protected String keyType;
	
	protected IAccess accessObj;
	
	
	public ApplicationUser(String userName, String email, String password, String mobileNumber, String keyType) {
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.keyType = keyType;
	}
	
	
	
	/*Methods*/
	abstract void register(Database d);
	abstract void login();
}
