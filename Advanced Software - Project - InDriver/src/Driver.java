import java.util.ArrayList;

public class Driver extends ApplicationUser implements IDriver, IRates {
	
	/*Attributes*/
	private String drivingLicense = "";
	private String nationalID = "";
	private boolean approved = false;
	private float avgRating;
	private String userDestination;
	private String userSource;
	private IUserRide nearbyUser;
	
	public ArrayList<String> favAreas;
	public ArrayList<DriverRatings> userRatings;
	
	/*Constructor*/
	public Driver(String userName, String email, String password, String mobileNumber, String keyType, String drivingLicense, String nationalID) {
		super(userName, email, password, mobileNumber, keyType);
		this.drivingLicense = drivingLicense;
		this.nationalID = nationalID;
		
		favAreas = new ArrayList<String>();
		userRatings = new ArrayList<DriverRatings>();
		avgRating = 0;
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
	
	public boolean listRides() {
		if(nearbyUser == null) {
			System.out.println("There is no nearby passengers");
			System.out.println("");
			return false;
		}
		
		System.out.println(nearbyUser);
		System.out.println("Source: " + this.userSource);
		System.out.println("Destination: " + this.userDestination);
		return true;
	}
	
	public void update(IUserRide user, String userSource, String userDestination) {
		nearbyUser = user;
		this.userSource = userSource;
		this.userDestination = userDestination;
	}
	
	public void removeUser() {	//Canceling the ride.
		nearbyUser = null;
	}
	
	public void offer(float offer) {
		nearbyUser.receiveOffer(offer, this);
	}

	public void setRate(int rate) {
		DriverRatings drvRatings = new DriverRatings(rate, nearbyUser);
		userRatings.add(drvRatings);	//Adding the rating of the user to the array list.
	}
	
	public void calcAvgRate() {

		int temp = 0;
		for(int i = 0; i < userRatings.size(); i++) {
			temp += userRatings.get(i).getRate();
		}
		avgRating = temp / userRatings.size();
	}
	
	public void listUserRatings() {
		
		if(userRatings.size() == 0) {	
			System.out.println("You have no user ratings in the meantime.");
			System.out.println("");
			return;
		}
		
		for(int i = 0; i < userRatings.size(); i++) {
			System.out.println("-----------------");
			System.out.println(userRatings.get(i));
			System.out.println("-----------------");
		}
	}
	
	/*Getters*/
	public String getNationalID() {
		return nationalID;
	}
	
	public String getDrivingLicense() {
		return drivingLicense;
	}
	
	public float getDriverAvgRating() {
		return avgRating;
	}

	public String getUserSource() {
		return userSource;
	}
	
	public String getUserDestination() {
		return userDestination;
	}
	
	public String toString() {
		return "Driver Name: " + getUsername()+ "\n" + "Mobile Number: " + getMobileNumber() + "\n" + "Driver Rating: " + getDriverAvgRating(); 
	}


}
