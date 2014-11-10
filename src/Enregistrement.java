
public class Enregistrement {
	private String rank;
	private String title;
	private String for1;
	private String for1Name;
	private String for2;
	private String for2Name;
	private String for3;
	private String for3Name;
	
	public Enregistrement(String rank, String title, String for1, String for1Name, String for2, String for2Name, String for3, String for3Name) {
		this.rank = rank;
		this.title = title;
		this.for1 = for1;
		this.for1Name = for1Name;
		this.for2 = for2;
		this.for2Name = for2Name;
		this.for3 = for3;
		this.for3Name = for3Name;
	}
	public Enregistrement(String rank, String title, String for1, String for1Name, String for2, String for2Name) {
		this(rank, title, for1, for1Name, for2, for2Name, null, null);
	}
	public Enregistrement(String rank, String title, String for1, String for1Name) {
		this(rank, title, for1, for1Name, null, null, null, null);
	}
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFor1() {
		return for1;
	}
	public void setFor1(String for1) {
		this.for1 = for1;
	}
	public String getFor1Name() {
		return for1Name;
	}
	public void setFor1Name(String for1Name) {
		this.for1Name = for1Name;
	}
	public String getFor2() {
		return for2;
	}
	public void setFor2(String for2) {
		this.for2 = for2;
	}
	public String getFor2Name() {
		return for2Name;
	}
	public void setFor2Name(String for2Name) {
		this.for2Name = for2Name;
	}
	public String getFor3() {
		return for3;
	}
	public void setFor3(String for3) {
		this.for3 = for3;
	}
	public String getFor3Name() {
		return for3Name;
	}
	public void setFor3Name(String for3Name) {
		this.for3Name = for3Name;
	}
	
	public String toString() {
		String result;
		result = "titre : "+title;
		result += "\n\tRank : "+rank+" ";
		result += (for1!=null)? ("\n\t- FoR1 : "+for1+" => FoR1 Name : "+for1Name):"";
		result += (for2!=null)? ("\n\t- FoR2 : "+for2+" => FoR2 Name : "+for2Name):"";
		result += (for3!=null)? ("\n\t- FoR3 : "+for3+" => FoR3 Name : "+for3Name):"";
		return result;
	}
}
