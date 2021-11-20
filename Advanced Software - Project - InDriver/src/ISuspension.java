
public interface ISuspension {
	public void listSuspendedUsers();
	public void suspend(String username, Database dtb);
	public void unsuspend(String username, Database dtb);

}
