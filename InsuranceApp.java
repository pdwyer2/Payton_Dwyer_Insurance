import java.util.Scanner;
import java.util.ArrayList;

import java.util.ArrayList;
public class InsuranceApp {
	
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
		System.out.print("Enter name of member file: ");
		String fname = sc.nextLine();
		String filetype;
		int choice;
		ArrayList<Member> members = MemberReader.readMembersFromTextFile(fname);
		do {
			userMenu();
			choice = sc.nextInt();
			if (choice == 1) {
				MemberWriter.writeMembersToScreen(members);
			} else if (choice == 2) {
				System.out.print("Enter first and last name: ");
				String userfirstname = sc.next();
				String userlastname = sc.next();
				System.out.print("Enter age: ");
				int userage = sc.nextInt();
				System.out.print("Enter height in inches: ");
				int userheight = sc.nextInt();
				System.out.print("Enter weight in pounds: ");
				int userweight = sc.nextInt();
				System.out.print("Enter blood pressure (sys and dia): ");
				int userBPsyst = sc.nextInt();
				int userBPdias = sc.nextInt();
				System.out.print("Has a family member had ...\n");
				System.out.print("Cancer? ");
				String usercancer = sc.next().toLowerCase();
				System.out.print("Diabetes? ");
				String userdiabetes = sc.next().toLowerCase();
				System.out.print("Alzheimers? ");
				String useralzheimers = sc.next().toLowerCase();
				members.add(new Member(userfirstname, userlastname, userage, userheight,
						userweight, userBPsyst, userBPdias, usercancer, 
						userdiabetes, useralzheimers));
			} else if (choice == 3) {
				System.out.print("(T)ext, (B)inary, or (X)ML? ");
				filetype = sc.next();
				if (filetype.equals("T")) {
					System.out.print("Enter name of output file: ");
					fname = sc.next();
					MemberWriter.writeMembersToTextFile(fname, members);
					System.out.println("");
				} else if (filetype.equals("B")) {
					System.out.print("Enter name of output file: ");
					fname = sc.next();
					MemberWriter.writeMembersToBinary(fname, members);
					System.out.println("");
				} else if (filetype.equals("X")) {
					System.out.print("Enter name of output file: ");
					fname = sc.next();
					MemberWriter.writeMembersToXML(fname, members);
					System.out.println("");
				}
			} else if (choice == 4) {
				int counter = 0;
				System.out.print("(T)ext, (B)inary, or (X)ML? ");
				filetype = sc.next();
				if (filetype.equals("T")) {
					System.out.print("Enter name of input file: ");
					fname = sc.next();
					MemberReader.readMembersFromTextFile(fname);	
					for (Member m : members) {
						counter = counter + 1;
					}
					System.out.println("");
					System.out.printf("%d members were read", counter);
					System.out.println("\n");
				} else if (filetype.equals("B")) {
					int counter2 = 0;
					System.out.print("Enter name of input file: ");
					fname = sc.next();
					MemberReader.readMembersFromBinary(fname);
					for (Member m : members) {
						counter2 = counter2 + 1;
					}
					System.out.println("");
					System.out.printf("%d members were read", counter2);
					System.out.println("\n");
				} else if (filetype.equals("X")) {
					int counter3 = 0;
					System.out.print("Enter name of input file: ");
					fname = sc.next();
					MemberReader.readMembersFromXML(fname);
					for (Member m : members) {
						counter3 = counter3 + 1;
					}
					System.out.println("");
					System.out.printf("%d members were read", counter3);
					System.out.println("\n");
				}
			} else if (choice == 5) {
				InsuranceScoreWriter.writeAssessmentsToScreen(members);
			} else if (choice == 6) {
				System.out.print("Enter name of JSON file: ");
				fname = sc.next();
				Assessor a = new Assessor();
				ArrayList<InsuranceScore> Members = a.scoreMembers(members);
				InsuranceScoreWriter.writeAssessmentsToJSON(fname, Members);
			}
		} while (choice != 7);
		System.out.println("Thanks for choosing this program for your insurance stuff.");
	}
}
