
public interface AdminAuthority {
	public void verifyDriver(String driverUserName, WaitingApproval wApp, Database dtb);
	public void suspend(String username, Database dtb, Suspension sus);
	public void unsuspend(String username, Database dtb, Suspension sus);
}
