package _11클렉션Member;

import java.util.ArrayList;
import java.util.Collections;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO(){init();}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private ArrayList<Member> memberList;
	private void init() {
		memberList = new ArrayList<Member>();
	}
	
	public void insertMember(String id, String pw) {
		memberList.add(new Member(id,pw));
		System.out.println("[ "+memberList.get(memberList.size()-1) + " 추가 완료 ]");
	}
	
	public int isVaildId(String id) {
		if(memberList.size()==0) return -1;
		for(int i =0; i<memberList.size(); i++) {
			if(memberList.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean pwCheck(int idx, String pw) {
		return memberList.get(idx).getPw().equals(pw);
	}
	
	public void removeMember(int idx) {
		System.out.println("[ "+memberList.get(idx) + " 삭제 완료 ]");
		memberList.remove(idx);
	}
	
	public void modifyMemberPw(int idx,String pw) {
		memberList.get(idx).setPw(pw);
		System.out.println("[ "+memberList.get(idx) + " 수정 완료 ]");
	}
	
	public void printMember() {
		if(memberList.size()==0) {
			System.out.println("    멤버가 없습니다 ");
			return;
		}
		ArrayList<Member> copy = (ArrayList<Member>) memberList.clone();
		Collections.sort(copy);
		for(Member m : copy) {
			System.out.println(m);
		}
	}
}
