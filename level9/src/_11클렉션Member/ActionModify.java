package _11클렉션Member;

public class ActionModify implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		System.out.println("[멤버 수정하기]");
		String id = Util.getValue("아이디 입력");
		String pw = Util.getValue("수정할 비밀번호 입력");
		
		dao.modifyMemberPw(id,pw);
		
	}
	
}
