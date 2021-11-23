
public interface ISuspension {
	public void listSuspendedUsers();
	public boolean suspend(String username, Database dtb);
	public boolean unsuspend(String username, Database dtb);

}
