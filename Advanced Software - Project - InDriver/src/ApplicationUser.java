
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
	
	public boolean register(Database dtb, ApplicationUser AU) {
		return accessObj.register(dtb, AU);
	}
	public ApplicationUser login(String username, String password, Database dtb) {
		return authorizeObj.login(username, password, dtb);
	}
	
	/*Getters*/
		
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public String keyType() {
		return keyType;
	}
}
