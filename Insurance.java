import java.util.Scanner;

import java.util.ArrayList;
public class Insurance {
	
	/**
	 This function prints a line of stars in order to add some decoration
	 to the application title.  It takes in the parameter howMany which 
	 allows the user to print a line of however many stars they desire.
	 To call the print stars function:
	 <pre>
	 printStars(integer number of stars desired);
	 <pre>
	 */
	public static void printStars(int howMany) {
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars);
	}
	
	/**
	 This function prints the welcome message properly formatted.
	 The title of the application "insurance score card" is centered 
	 along with the description for what the application can do for the user.
	 Also calls the print stars function.
	 To call the Welcome function:
	 <pre>
	 welcome();
	 </pre>
	 */
	public static void welcome() {
		String space = "               ";
		String title = "INSURANCE SCORE CARD";
		
		printStars(50);
		System.out.printf("%s" + "%s" + "%s", space, title, space);
		System.out.println("");
		System.out.println("       This app scores a potential customer\n       on various "
				+ "health attributes: blood\n       pressure, age, height, weight, and\n"
				+ "       family history of disease. It writes\n       each member's insurance "
				+ "grade to a\n       JSON file so that they can be easily\n       shared on a "
				+ "web-based data exchange.");
		printStars(50);
	}
	
	/**
	 This function prints the options that the user will be able to choose from within the application.
	 It also asks the user to choose an option.  To call this function:
	 <pre>
	 userMenu();
	 <pre>
	 */
	public static void userMenu() {
		System.out.println("Here are your choices:");
		System.out.println("       1. List members");
		System.out.println("       2. Add a new member");
		System.out.println("       3. Save members");
		System.out.println("       4. Load members");
		System.out.println("       5. Assess members");
		System.out.println("       6. Save assessments as JSON");
		System.out.println("       7. Exit");
		System.out.print("Please enter your choice: ");
		
	}
	
	/**
	 Main where the program is carried out. References various functions listed previously in order to print a menu. 
	 Asks the user to choose an option. Asks the user to input a file name. Reads the file. etc.
	 */
	public static void main(String[] args) {
		welcome();
		Scanner sc = new Scanner(System.in);
		String fname;
		System.out.print("Enter name of member file: ");
		fname = sc.nextLine();
		int choice;
		do {
			userMenu();
			choice = sc.nextInt();
			ArrayList<Member> members = MemberReader.readMembersFromTextFile(fname);
			if (choice == 1) {
				MemberWriter.writeMembersToScreen(members);
			} else if (choice == 2) {
				MemberAdder.AddMemberToList(members);
			} else if (choice == 3) {
				System.out.println("(T)ext, (B)inary, or (X)ML?");
				
				
			}
		} while (choice != 7);
		
	}
}
