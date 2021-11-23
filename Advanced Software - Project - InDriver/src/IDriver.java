
public interface IDriver {
	public void update(IUserRide user, String s, String d);
	public void offer(float s);
	public boolean listRides();
	public void calcAvgRate();
	public void setRate(int rate);
	public float getDriverAvgRating();	
	public void removeUser();
}
	

