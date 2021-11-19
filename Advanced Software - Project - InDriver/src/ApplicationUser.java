
public abstract class ApplicationUser {
	/*Attributes*/
	protected String username;
	protected String mobileNumber;
	protected String email;
	protected String password;
	protected String keyType;
	
	protected IAccess accessObj;
	protected IAuthorize authorizeObj;
	
	public ApplicationUser(String username, String email, String password, String mobileNumber, String keyType) {
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.keyType = keyType;	
	}
	
	public void setAccess(IAccess accessObj) {
		this.accessObj = accessObj;
	}
	
	public void setAuthorization(IAuthorize authorizeObj) {
		this.authorizeObj = authorizeObj;
	}
	
	
	/*Methods*/
	
	abstract void register(Database dtb, ApplicationUser AU);
	
	abstract void login(String username, String password, Database dtb);

	
	
	/*Getters*/
	
	abstract public String getKey();
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	
	
}
