import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		/*Error messages*/
		String invalidInputMessage = "Invalid Input";
		String invalidUsernameOrPassword = "Invalid username or password, please, try again";
		String usernameNotAvailable = "Username is not available, please, Choose another Username";
		
		String username, email, password, mobileNumber, nationalID, drivingLicense;
		String unapprovedDriver, favArea, source, destination;
		int mainChoice, registerChoice, loginChoice, adminOption, driverOption, userOption, offerChoice, rate;
		float offer;
		
		Database dtb = new Database();
		Verification verification = new Verification();
		Suspension suspension = new Suspension();	

		//Creating only one admin in the system.
		ApplicationUser adminToBeDownCasted = new Admin("admin","admin@admin","admin","+2013526","Admin");
		adminToBeDownCasted.setAccess(new Register());
		adminToBeDownCasted.setAuthorization(new Login());
		adminToBeDownCasted.register(dtb, adminToBeDownCasted);
		Admin admin = (Admin) adminToBeDownCasted;	//Down Casting
		admin.setSuspension(suspension);
		admin.setVerification(verification);
		
		while(true) {
			
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			mainChoice = Integer.parseInt(reader.nextLine());
			
			if (mainChoice == 1) {	//Register
				System.out.println("1. Register as a User");
				System.out.println("2. Register as a Driver");
				System.out.println("3. Back to the main menu");
				
				registerChoice = Integer.parseInt(reader.nextLine());
				System.out.println("");
				
				if(registerChoice == 1) {	//USER
					
					System.out.println("Username: ");
					username = reader.nextLine();
					System.out.println("Email: ");
					email = reader.nextLine();		
					System.out.println("Mobile Number: ");
					mobileNumber = reader.nextLine();
					System.out.println("Password: ");
					password = reader.nextLine();
					
					ApplicationUser userToBeDownCasted = new User(username, email, password, mobileNumber, "User");
					
					userToBeDownCasted.setAccess(new Register());
					
					//Returns false if the username is not available
					if(!userToBeDownCasted.register(dtb, userToBeDownCasted) || username.equals("admin")) {
						System.out.println(usernameNotAvailable);
					}
					
				}
				else if(registerChoice == 2) {	//DRIVER
					System.out.println("Username: ");
					username = reader.nextLine();
					System.out.println("Email: ");
					email = reader.nextLine();		
					System.out.println("Mobile Number: ");
					mobileNumber = reader.nextLine();
					System.out.println("National ID: ");
					nationalID = reader.nextLine();
					System.out.println("Driving License: ");
					drivingLicense = reader.nextLine();
					System.out.println("Password: ");
					password = reader.nextLine();
					
					ApplicationUser driverToBeDownCasted = new Driver(username, email, password, mobileNumber, "Driver", drivingLicense, nationalID);
					driverToBeDownCasted.setAccess(new Register());
					
					//Returns true if the username is available in the database
					boolean check1 = driverToBeDownCasted.register(dtb, driverToBeDownCasted);
					//Returns true if the username is available in the unapprovedDrivers List
					boolean check2 = verification.checkUsername(username);
					
					if(check1 && check2 && !username.equals("admin")) {
						Driver driver = (Driver) driverToBeDownCasted;	//Down Casting
						verification.addUnapprovedDriver(driver);	
					}
					else {
						System.out.println(usernameNotAvailable);
					}

				}

				else if(registerChoice == 3){
					continue;
				}
				else {
					System.out.println(invalidInputMessage);
				}

			}
			else if (mainChoice == 2) {	//Login
				
				System.out.println("Enter username: ");
				username = reader.nextLine();
				System.out.println("Enter Password: ");
				password = reader.nextLine();	
				System.out.println("");
				
				if(admin.login(username, password, dtb) != null) {	//Logged in
					ApplicationUser applicationUser = admin.login(username, password, dtb);
					
					if(applicationUser instanceof User) {	//User
						
						User user = (User) applicationUser;
						
						while(true) {
							System.out.println("1. Request a ride");
							System.out.println("2. List offers");
							System.out.println("3. Log out");
							
							userOption = Integer.parseInt(reader.nextLine());
							
							if(userOption == 1) {
								System.out.println("Enter source area's name: ");
								source = reader.nextLine();
								System.out.println("Enter destination area's name: ");
								destination = reader.nextLine();
								
								user.addDriver(dtb, source);
								
								if(!user.requestRide(source, destination)) {	//Returns false if there is no nearby drivers in this area.
									System.out.println("There is no nearby drivers in this area.");
								}
								
								
								System.out.println("");
							}
							else if(userOption == 2) {	//List offers.
								
								if(user.getDriver() == null) {	//No drivers.
									System.out.println("No nearby drivers");
								}
								else {
									System.out.println(user.getDriver());
									System.out.println("");
									System.out.println("Offer: " + user.getOffer());
									System.out.println("");
									System.out.println("1. Accept");
									System.out.println("2. Deny");
									offerChoice = Integer.parseInt(reader.nextLine());
									
									if(offerChoice == 1) {	//Accept
										
										System.out.println("Rate ride 1:5 (1 Worst/ 5 Best)");
										rate = Integer.parseInt(reader.nextLine());
										
										if(rate > 5 || rate < 1) {
											System.out.println(invalidInputMessage);
											continue;
										}
										
										user.rateRide(rate);
										user.getDriver().calcAvgRate();
										user.cancelRide(); //Removes the ride from all drivers (No longer needed.)
										user.removeDrivers();	//Removes the nearby drivers from user
									}
									else if(offerChoice == 2) {	//Deny
										user.removeDrivers();
									}
									else {
										System.out.println(invalidInputMessage);
									}
									
									user.receiveOffer(0, null); //Reinitializing the driver.
								}

							}
							else if(userOption == 3) {
								break;
							}
							else {
								System.out.println(invalidInputMessage);
							}
							
						}
						
					}
					else if(applicationUser instanceof Driver) {	//Driver
						Driver driver = (Driver) applicationUser;
						
						while(true) {
							System.out.println("1. Add favorite area");
							System.out.println("2. List available rides");
							System.out.println("3. List user ratings");
							System.out.println("4. Log out");
							
							driverOption = Integer.parseInt(reader.nextLine());
							
							if(driverOption == 1) {
								System.out.println("Enter favorite area: ");
								favArea = reader.nextLine();
								driver.addFavArea(favArea);
								System.out.println("Area has been added!");
								System.out.println("");
							}
							else if(driverOption == 2) {
								System.out.println("");
								if(driver.listRides()) {	//If there are nearby passengers.		
									System.out.println("");
									System.out.println("Enter offer: ");
									offer = Float.parseFloat(reader.nextLine());
									driver.offer(offer);  //Sending the offer price to the user.
								}
							}
							else if(driverOption == 3) {
								driver.listUserRatings();
							}
							else if(driverOption == 4) {
								break;
							}
							else {
								System.out.println(invalidInputMessage);
							}
						}
					}
					else if(applicationUser instanceof Admin) {	//Admin
						
						while(true) {
							System.out.println("1. List unapproved drivers");
							System.out.println("2. Approve a driver");
							System.out.println("3. List suspended users");
							System.out.println("4. Suspend an account");
							System.out.println("5. Unsuspend an account");
							System.out.println("6. Log out");
							
							adminOption = Integer.parseInt(reader.nextLine());
							
							if(adminOption == 1) {	//List unapproved drivers 
								admin.listPendingRequests();
							}
							else if (adminOption == 2) {	//Approve a driver
								System.out.println("Enter the driver's username: ");
								unapprovedDriver = reader.nextLine();
								
								if(!admin.verifyDriver(unapprovedDriver, dtb)) {	//If the unapproved driver wasn't found in the list.
									System.out.println("Driver was not found");
									System.out.println("");
									continue;
								}
								
								System.out.println("Driver has been approved!");
								System.out.println("");
								
							}
							else if (adminOption == 3) {	//List suspened users
								admin.listSuspendedUsers();
							}
							else if (adminOption == 4) {	//Suspend an account
								System.out.println("Enter the user's username: ");
								username = reader.nextLine();
								
								if(!admin.suspend(username, dtb)) {		//If the user wasn't found in the list.
									System.out.println("Account was not found");
									System.out.println("");
									continue;
								}
								
								System.out.println("Account has been suspended");
								System.out.println("");
							}
							else if (adminOption == 5) {	//Unsuspend an account
								System.out.println("Enter the user's username: ");
								username = reader.nextLine();
								if(!admin.unsuspend(username, dtb)) {		//If the user wasn't found in the list.
									System.out.println("Account was not found");
									System.out.println("");
									continue;
								}
								
								System.out.println("Account has been unsuspended");
								System.out.println("");
							}
							
							else if (adminOption == 6) {
								break;
							}
							else {
								System.out.println(invalidInputMessage);
							}
						}
					}
				}
				else {	
					System.out.println(invalidUsernameOrPassword);
				}
			}
				
			else if(mainChoice == 3){
				break;
			}
			else {
				System.out.println(invalidInputMessage);
			}

		}
		
		
		reader.close();
	}

}
