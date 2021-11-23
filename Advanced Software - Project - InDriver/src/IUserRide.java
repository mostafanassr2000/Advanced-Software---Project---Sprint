
public interface IUserRide {
	public boolean requestRide(String s, String d);
	public void addDriver(Database dtb, String source);
	public void cancelRide();
	public void removeDrivers();
	public void receiveOffer(float offer, IDriver driver);
	public void rateRide(int rate);
	public String getUsername();
	public float getDriverAvgRate();
}
