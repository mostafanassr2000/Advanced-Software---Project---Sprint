import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String errorMessage = "Invalid Input";
		
		String userName, email, password, mobileNumber, nationalID, drivingLicense;
		String unapprovedDriver;
		int mainChoice, registerChoice, loginChoice, adminOption;
		
		Database dtb = new Database();
		WaitingApproval waitingApproval = new WaitingApproval();
		
	
		
		//ApplicationUser user = null;
		
		ApplicationUser user = new User("User","","","","");
		user.registerUser(user);	//?????
		
		for(int i = 0; i < dtb.dat.size(); i++) {
			System.out.println(dtb.dat.get(i));
		}
		
		
		
		/*
		while(true) {
			
			System.out.println("1. Register");
			System.out.println("2. Login");
			mainChoice = Integer.parseInt(reader.nextLine());
			
			if (mainChoice == 1) {	//Register
				System.out.println("1. Register as a User");
				System.out.println("2. Register as a Driver");
				System.out.println("3. Register as an Admin");
				
				registerChoice = Integer.parseInt(reader.nextLine());
				
				if(registerChoice == 1) {	//USER
					User user = new User("mostafa", "mostafa@user", "123", "+02205", "user");
					user.register(dtb);
				}
				else if(registerChoice == 2) {	//DRIVER
					Driver driver = new Driver("Ahmed", "ahmed@yes", "123", "01121", "driver","30011300", "5555");
					waitingApproval.addUnapprovedDriver(driver);
					
				}
				else if (registerChoice == 3) {	//ADMIN
					Admin admin = new Admin("Admin", "admin@admin", "123", "01121", "admin");
					dtb.addAdmin(admin);
					
					while(true) {
						System.out.println("1. List unapproved drivers");
						System.out.println("2. Approve a driver");
						System.out.println("3. Back to account");
						
						adminOption = Integer.parseInt(reader.nextLine());
						
						if(adminOption == 1) {
							admin.listPendingRequests(waitingApproval);
						}
						else if (adminOption == 2) {
							System.out.println("Enter the driver's username: ");
							unapprovedDriver = reader.nextLine();
							
							admin.verifyDriver(unapprovedDriver, waitingApproval, dtb);
							
						}
						else if (adminOption == 3) {
							break;
						}
						else {
							System.out.println(errorMessage);
						}
					}

					
				}
				else {
					break;
				}
				

			}
			else if (mainChoice == 2) {	//Login
				
			}
			else {
				break;
			}

		}
		
		
		System.out.println("Users");
		for(int i = 0; i < dtb.users.size(); i++) {
			System.out.println(dtb.users.get(i));
		}
		System.out.println("--------------------------------");
		
		
		System.out.println("Drivers");
		for(int i = 0; i < dtb.drivers.size(); i++) {
			System.out.println(dtb.drivers.get(i));
		}
		System.out.println("--------------------------------");

		System.out.println("Admin");
		for(int i = 0; i < dtb.admins.size(); i++) {
			System.out.println(dtb.admins.get(i));
		}
		System.out.println("--------------------------------");
		*/

		reader.close();
	}

}
