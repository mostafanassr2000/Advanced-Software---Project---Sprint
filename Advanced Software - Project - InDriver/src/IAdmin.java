
public interface IAdmin{

	public void setSuspension(ISuspension suspensionObj);
	
	public void setVerification(IVerification verificationObj);
	
	public void listPendingRequests();

	public boolean verifyDriver(String driverUserName, Database dtb);
	
	public void listSuspendedUsers();
	
	public boolean suspend(String un, Database dtb);
	
	public boolean unsuspend(String un, Database dtb);
	
}
