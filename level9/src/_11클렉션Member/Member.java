package _11클렉션Member;

public class Member implements Comparable<Member>{
	private String id;
	private String pw;
	
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return id+"\t"+pw;
	}

	@Override
	public int compareTo(Member o) {
		return id.compareTo(o.id);
	}	
}
