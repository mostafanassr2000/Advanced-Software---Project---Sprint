import java.util.ArrayList;

public class Driver extends ApplicationUser implements IDriver {
	
	/*Attributes*/
	private String drivingLicense = "";
	private String nationalID = "";
	private boolean approved = false;
	public ArrayList<String> favAreas;
	
	public ArrayList<User> nearbyPassengers;	//Nearby passengers.
	
	/*Constructor*/
	public Driver(String userName, String email, String password, String mobileNumber, String keyType, String drivingLicense, String nationalID) {
		super(userName, email, password, mobileNumber, keyType);
		this.drivingLicense = drivingLicense;
		this.nationalID = nationalID;
		favAreas = new ArrayList<String>();
		nearbyPassengers = new ArrayList<User>();
	}
	
	/*Methods*/
	
	public void setApproval() {
		approved = true;
	}

	public boolean isApproved() {
		return approved;
	}
	
	public void addFavArea(String favArea) {
		favAreas.add(favArea);
	}
	
	public void update(User user) {
		nearbyPassengers.add(user);
	}

	public void offer() {
	
	}

	public void listRides() {
		for(User user : nearbyPassengers) {
			System.out.println(user);
		}
	}
	
	
	/*Getters*/
	public String getNationalID() {
		return nationalID;
	}
	
	public String getDrivingLicense() {
		return drivingLicense;
	}
	
	public String toString() {
		return "User Name: " + getUsername() + "-----" + "Type: " + keyType(); 
	}


}
