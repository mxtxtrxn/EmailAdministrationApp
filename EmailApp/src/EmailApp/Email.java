// CAMILO 
// @mxtxtrxn

package EmailApp;

import java.util.Scanner;

public class Email {
	private String FirstName;
	private String LastName;
	private String password;
	private String Department;
	private String email;
	private int mailBoxCapacity = 700;
	private int Default_Password_Length = 10;
	private String alternEmail;
	private String companySuffix = "mxtxtrxn.com";
	
	//constructor to get the first and last name
	
	public Email(String FirstName, String LastName) {
		this.FirstName = FirstName;
		this.LastName = LastName;
	
		// Call a method asking for the department -> Return the department
		this.Department = setDepartment();
		
		// Call a method that return a random password
		this.password = RandomPassword(Default_Password_Length);
		System.out.println("Your password is: " + this.password);
		
		//Combine elements to generate a e-mail
		email = FirstName.toLowerCase()+"."+LastName.toLowerCase()+"@"+Department+ "." +companySuffix;
		
	}
	
	// ask for the department
	
	private String setDepartment() {
		System.out.println("New worker: "+ FirstName + ". Department code:\n 1. Sales \n 2. Development \n 3. Accounting \n 4. None \n Enter department code: ");
		Scanner in = new Scanner(System.in);
		int  DepChoice = in.nextInt();
		if(DepChoice == 1) {return "sales";}
		else if(DepChoice == 2) {return "Development";}
		else if(DepChoice == 3) {return "Accounting";}
		else {return "";}
	}
	
	
	//generate a random password
	private String RandomPassword(int length) {
		String PasswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!#$%&=?¡¿";
		char[] password = new char[length];
		for(int i= 0; i< length; i++) {
			int rand = (int) (Math.random() * PasswordSet.length());
			password[i]= PasswordSet.charAt(rand);
		}
		return new String(password);
	}
	
	
	// set the mailbox capacity
	public void SetMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
		
	}
	
	// Set the alternate email
	public void SetAlternateEmail(String altEmail) {
		this.alternEmail = altEmail;
	}
	
	
	//change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailBoxCapacity() {return mailBoxCapacity;}
	public String getAlternateEmail() {return alternEmail; }
	public String getPassword() {return password; }
	public String ShowInfo() {
		return "DISPLAY NAME: " + FirstName + " " + LastName + "\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: "+ mailBoxCapacity + " mb.";
	}
}
