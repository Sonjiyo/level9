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
		if(isVaildId(id)!=-1) {
			System.out.println("이미 등록된 아이디입니다.");
			return;
		}
		
		memberList.add(new Member(id,pw));
		System.out.println("[ "+memberList.get(memberList.size()-1) + " 추가 완료 ]");
	}
	
	private int isVaildId(String id) {
		if(memberList.size()==0) return -1;
		for(int i =0; i<memberList.size(); i++) {
			if(memberList.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean pwCheck(int idx, String pw) {
		return memberList.get(idx).getPw().equals(pw);
	}
	
	public void removeMember(String id, String pw) {
		int idx = isVaildId(id);
		if(idx==-1) {
			System.out.println("아이디를 확인할 수 없습니다.");
			return;
		}
		
		if(!pwCheck(idx,pw)) {
			System.out.println("비밀번호가 올바르지 않습니다.");
			return;
		}
		
		System.out.println("[ "+memberList.get(idx) + " 삭제 완료 ]");
		memberList.remove(idx);
	}
	
	public void modifyMemberPw(String id, String pw) {
		int idx = isVaildId(id);
		if(idx==-1) {
			System.out.println("아이디를 확인할 수 없습니다.");
			return;
		}
		
		if(pwCheck(idx,pw)) {
			System.out.println("이전에 사용하던 비밀번호와 동일합니다.");
			return;
		}
		
		memberList.get(idx).setPw(pw);
		System.out.println("[ "+memberList.get(idx) + " 수정 완료 ]");
	}
	
	public void printMember() {
		if(memberList.size()==0) {
			System.out.println("    멤버가 없습니다 ");
			return;
		}
		for(Member m : memberList) {
			System.out.println(m);
		}
		System.out.println("--- id 순서로 정렬 ---");
		ArrayList<Member> copy = (ArrayList<Member>) memberList.clone();
		Collections.sort(copy);
		for(Member m : copy) {
			System.out.println(m);
		}
	}
	
	public String memberDataSave() {
		String data = "";
		if(memberList.size()==0) return data;
		for(Member m : memberList) {
			data += m.getId()+"/"+m.getPw()+"\n";
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
	
	public void memberDataLoad(String data) {
		memberList.clear();
		if(data.isEmpty()) return;
		String dataList[] = data.split("\n");
		for(String d : dataList) {
			String[] arr = d.split("/");
			memberList.add(new Member(arr[0],arr[1]));
		}
		System.out.println("[불러오기 성공]");
	}
}
