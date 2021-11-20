import java.util.ArrayList;

public class User extends ApplicationUser implements IRide{
	
	/*Attributes*/
	public ArrayList<IDriver> nearbyDrivers;	

	private String source = "";
	private String destination = "";
	
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
			drv.update(this);
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

	public void freeArrayList() {
		for(int i = 0; i < nearbyDrivers.size(); i++) {
			nearbyDrivers.remove(i);
		}
	}
	
	
	/*Getters*/
	public String getSource() {
		return source;
	}
	
	public String getDestination() {
		return destination;
	}

	public String toString() {
		return "User Name: " + getUsername() + "-----" + "Type: " + keyType(); 
	}

}
