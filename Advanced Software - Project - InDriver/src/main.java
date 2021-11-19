import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String invalidInputMessage = "Invalid Input";
		String invalidUsernameOrPassword = "Invalid username or password, please, try again";
		
		String username, email, password, mobileNumber, nationalID, drivingLicense;
		String unapprovedDriver;
		int mainChoice, registerChoice, loginChoice, adminOption;
		
		Database dtb = new Database();
		WaitingApproval waitingApproval = new WaitingApproval();
		
	
		/*
		//ApplicationUser user = null;
		
		ApplicationUser kbeer1 = new User("User","blabl","dsd","321","User");
		kbeer1.setAccess(new Register());
		kbeer1.register(dtb, kbeer1);
		User user = (User) kbeer1;
		System.out.println(user.getKey());
		System.out.println("------------------");
		
		ApplicationUser kbeer2 = new Driver("Driver1","blabl","dsd","321","Driver", "", "");
		kbeer2.setAccess(new Register());
		kbeer2.register(dtb, kbeer2);
		Driver driver = (Driver) kbeer2;	//Down casting
		System.out.println(driver.getKey());
		System.out.println("------------------");
		
		ApplicationUser kbeer3 = new Admin("Admin","blabl","dsd","321","Admin");
		kbeer3.setAccess(new Register());
		kbeer3.register(dtb, kbeer3);
		Admin admin = (Admin) kbeer3;
		System.out.println(admin.getKey());
		System.out.println("------------------");
*/
		
		/*
		for(int i = 0; i < dtb.applicationUsers.size(); i++) {
			
			if(dtb.applicationUsers.get(i) instanceof Driver){
				Driver driver1 = (Driver) dtb.applicationUsers.get(i);	//Down casting
				driver1.test();
			}
			
			System.out.println(dtb.applicationUsers.get(i));
		}*/
		
		
		

		while(true) {
			
			System.out.println("1. Register");
			System.out.println("2. Login");
			mainChoice = Integer.parseInt(reader.nextLine());
			
			if (mainChoice == 1) {	//Register
				System.out.println("1. Register as a User");
				System.out.println("2. Register as a Driver");
				System.out.println("3. Back to the main menu");
				
				registerChoice = Integer.parseInt(reader.nextLine());
				
				if(registerChoice == 1) {	//USER
					ApplicationUser userToBeDownCasted = new User("mostafa", "mostafa@user", "123", "+02205", "user");
					userToBeDownCasted.setAccess(new Register());
					userToBeDownCasted.register(dtb, userToBeDownCasted);
					//User user = (User) userToBeDownCasted;	//Down Casting
					
					
				}
				else if(registerChoice == 2) {	//DRIVER
					ApplicationUser driverToBeDownCasted = new Driver("Ahmed", "ahmed@yes", "123", "01121", "driver","30011300", "5555");
					Driver driver = (Driver) driverToBeDownCasted;	//Down Casting
					waitingApproval.addUnapprovedDriver(driver);	
				}

				else if(registerChoice == 3){
					break;
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
				/*
				if() {
					
				}
				else {
					System.out.println(invalidUsernameOrPassword);
				}*/
				

			}
			else {
				break;
			}

		}
		
		
		reader.close();
	}

}










/*
ApplicationUser adminToBeDownCasted = new User("mostafa", "mostafa@user", "123", "+02205", "user");
userToBeDownCasted.setAccess(new Register());
userToBeDownCasted.register(dtb, userToBeDownCasted);
User user = (User) userToBeDownCasted;	//Down Casting

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
*/
