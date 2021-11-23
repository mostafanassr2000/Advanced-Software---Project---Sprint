public class DriverRatings {

	/*Attributes*/
	private float rate;
	private IUserRide user; 
	
	/*Constructor*/
	public DriverRatings(float rate, IUserRide user) {
		this.rate = rate;
		this.user = user;	
	}
	
	/*Getters*/
	
	public float getRate() {
		return rate;
	}
	
	public IUserRide getUser() {
		return user;
	}
	
	/*toString*/
	public String toString() {
		return "Name: " + getUser().getUsername() + " - " + "User rating: " + getRate();
	}
	
}
