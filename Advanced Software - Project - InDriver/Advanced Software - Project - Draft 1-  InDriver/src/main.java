import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		/*Error messages*/
		String invalidInputMessage = "Invalid Input";
		String invalidUsernameOrPassword = "Invalid username or password, please, try again";
		String usernameNotAvailable = "Username is not available, please, Choose another Username";
		
		String username, email, password, mobileNumber, nationalID, drivingLicense;
		String unapprovedDriver;
		int mainChoice, registerChoice, loginChoice, adminOption;
		
		Database dtb = new Database();
		WaitingApproval waitingApproval = new WaitingApproval();
		Suspension suspension = new Suspension();	

		//Creating only one admin in the system.
		ApplicationUser adminToBeDownCasted = new Admin("admin","admin@admin","admin","+2013526","Admin");
		adminToBeDownCasted.setAccess(new Register());
		adminToBeDownCasted.setAuthorization(new Login());
		adminToBeDownCasted.register(dtb, adminToBeDownCasted);
		Admin admin = (Admin) adminToBeDownCasted;	//Down Casting
		
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
					boolean check2 = waitingApproval.checkUsername(username);
					
					if(check1 && check2 && !username.equals("admin")) {
						Driver driver = (Driver) driverToBeDownCasted;	//Down Casting
						waitingApproval.addUnapprovedDriver(driver);	
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
				
				if(admin.login(username, password, dtb) != null) {	//Logged in
					ApplicationUser applicationUser = admin.login(username, password, dtb);
					
					if(applicationUser instanceof User) {	//User
						
					}
					else if(applicationUser instanceof Driver) {	//Driver
						
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
								admin.listPendingRequests(waitingApproval);
							}
							else if (adminOption == 2) {	//Approve a driver
								System.out.println("Enter the driver's username: ");
								unapprovedDriver = reader.nextLine();
								admin.verifyDriver(unapprovedDriver, waitingApproval, dtb);
							}
							else if (adminOption == 3) {	//List suspened users
								admin.listSuspendedUsers(suspension);
							}
							else if (adminOption == 4) {	//Suspend an account
								System.out.println("Enter the user's username: ");
								username = reader.nextLine();
								admin.suspend(username, dtb, suspension);
								System.out.println("User has been suspended");
							}
							else if (adminOption == 5) {	//Unsuspend an account
								System.out.println("Enter the user's username: ");
								username = reader.nextLine();
								admin.unsuspend(username, dtb, suspension);
								System.out.println("User has been unsuspended");
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
