import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;
public class MemberWriter {
	public static void writeMembersToScreen(ArrayList<Member> members) {
		System.out.println("");
		for (Member m: members) {
			System.out.print(m);
		}
		System.out.println("");
	}
	public static boolean writeMembersToTextFile(String fname, 
			ArrayList<Member> members) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(
					new FileWriter(fname)));
			for (Member m : members) {
				pw.println(m);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
}
