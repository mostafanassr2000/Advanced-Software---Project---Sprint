import java.util.ArrayList;

public class User extends ApplicationUser implements IUserRide{
	
	/*Attributes*/
	public ArrayList<IDriver> nearbyDrivers;	

	private String source = "";
	private String destination = "";
	private float receivedOffer;
	private IDriver currentDriver;
	
	/*Constructor*/
	public User(String username, String email, String password, String mobileNumber, String keyType) {
		super(username, email, password, mobileNumber, keyType);
		
		nearbyDrivers = new ArrayList<IDriver>();
	}

	/*Methods*/

	public boolean requestRide(String source, String destination) {
		this.source = source;
		this.destination = destination;
		
		if(nearbyDrivers.size() == 0) {	//There is no nearby drivers in this area.
			return false;
		}
		
		for(IDriver drv : nearbyDrivers) {	//Notify Drivers
			drv.update(this, source, destination);
		}
		
		return true;
	}
	
	public void addDriver(Database dtb, String source) {
		this.source = source;
		
		//Getting all drivers who have the source area as their favorite area
		for(ApplicationUser au : dtb.applicationUsers) {	
			if(au instanceof Driver) {
				Driver drv = (Driver) au;	//Down Casting
				for(String favArea : drv.favAreas) {
					if(favArea.equals(source)) {
						nearbyDrivers.add(drv);
					}
				}
			}
		}		
	}
	
	public void cancelRide() {
		for(IDriver drv : nearbyDrivers) {	//Removing the ride from all drivers.
			drv.removeUser();
		}
	}

	public void removeDrivers() {
		for(int i = 0; i < nearbyDrivers.size(); i++) {
			nearbyDrivers.remove(i);
		}
	}
	
	public void receiveOffer(float offer, IDriver driver) {	//Receives the offer from the driver
		receivedOffer = offer;
		this.currentDriver = driver;
	}
	
	public void rateRide(int rate) {
		currentDriver.setRate(rate);
	}
	
	public float getDriverAvgRate() {
		return currentDriver.getDriverAvgRating();
	}
	
	/*Getters*/
	public String getSource() {
		return source;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public float getOffer() {
		return receivedOffer;
	}
	
	public IDriver getDriver() {
		return currentDriver;
	}
	
	public String getUsername() {
		return username;
	}

	public String toString() {
		return "Name: " + getUsername()+ "\n" + "Mobile Number: " + getMobileNumber(); 
	}

}
