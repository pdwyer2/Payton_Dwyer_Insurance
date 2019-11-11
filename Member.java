import java.util.ArrayList;

public class Member {
	private String firstname;
	private String lastname;
	private int age;
	private int height;
	private int weight;
	private int BPsyst;
	private int BPdias;
	private String cancer;
	private String diabetes;
	private String alzheimers;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getBPsyst() {
		return BPsyst;
	}
	public void setBPsyst(int BPsyst) {
		this.BPsyst = BPsyst;
	}
	public int getBPdias() {
		return BPdias;
	}
	public void setBPdias(int BPdias) {
		this.BPdias = BPdias;
	}
	public String getCancer() {
		return cancer;
	}
	public void setCancer(String cancer) {
		this.cancer = cancer;
	}
	public String getDiabetes() {
		return diabetes;
	}
	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}
	public String getAlzheimers() {
		return alzheimers;
	}
	public void setAlzheimers(String alzheimers) {
		this.alzheimers = alzheimers;
	}
	public Member() {
		firstname = "";
		lastname = "";
		age = 0;
		weight = 0;
		BPsyst = 0;
		BPdias = 0;
		cancer = "";
		diabetes = "";
		alzheimers = "";
	}
	public Member(String firstname, String lastname, int age, int height, int weight, int BPsyst, int BPdias,
			String cancer, String diabetes, String alzheimers) {
		setFirstname(firstname);
		setLastname(lastname);
		setAge(age);
		setWeight(weight);
		setHeight(height);
		setBPsyst(BPsyst);
		setBPdias(BPdias);
		setCancer(cancer);
		setDiabetes(diabetes);
		setAlzheimers(alzheimers);
	}
	@Override
	public String toString() {
		return String.format("%s" + "," + "%s\n" + "Age" + "%23d\n" + "Height"
				+ "%20d" + " in\n" + "Weight" + "%20d" + " lbs\n" + "BP Syst"
				+ "%19d\n" + "BP Dias" + "%19d\n" + "Cancer" + "%20s\n"
				+ "Diabetes" + "%18s\n" + "Alzheimers" + "%16s\n"
				+ "--------------------------------\n",lastname,firstname,age,height,
				weight,BPsyst,BPdias,cancer,diabetes,alzheimers);
	}
}
