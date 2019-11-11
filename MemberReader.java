import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class MemberReader {
	public static ArrayList<Member> readMembersFromTextFile(String fname) {
		ArrayList<Member> members = new ArrayList<Member>();
		try {
			Scanner fsc = new Scanner(new File(fname));
			String line, firstname = null, lastname = null, cancer = null, diabetes = null, alzheimers = null;
			int age = 0, height = 0, weight = 0, BPsyst = 0, BPdias = 0;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				String[] parts = line.split("\t");
				for (String part : parts) {
					firstname = parts[0];
					lastname = parts[1];
					age = Integer.parseInt(parts[2]);
					height = Integer.parseInt(parts[3]);
					weight = Integer.parseInt(parts[4]);
					BPsyst = Integer.parseInt(parts[5]);
					BPdias = Integer.parseInt(parts[6]);
					cancer = parts[7];
					diabetes = parts[8];
					alzheimers = parts[9];					
				}
				members.add(new Member(firstname, lastname, age, height, weight,
						BPsyst, BPdias, cancer, diabetes, alzheimers));
			}
			fsc.close();
			return members;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
