
public interface IVerification {
	public void verifyDriver(String driverUserName, Database dtb);
	public void listPendingRequests();
	public boolean checkUsername(String username);
	public void addUnapprovedDriver(Driver unapprovedDriver);
	
}
