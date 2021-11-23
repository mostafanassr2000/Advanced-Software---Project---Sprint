
public interface IVerification {
	public boolean verifyDriver(String driverUserName, Database dtb);
	public void listPendingRequests();
	public boolean checkUsername(String username);
	public void addUnapprovedDriver(Driver unapprovedDriver);
}
