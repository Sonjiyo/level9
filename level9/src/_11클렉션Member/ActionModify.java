package _11클렉션Member;

public class ActionModify implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		System.out.println("[멤버 수정하기]");
		String id = Util.getValue("아이디 입력");
		
		int idx = dao.isVaildId(id);
		if(idx==-1) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		
		String pw = Util.getValue("수정할 비밀번호 입력");
		if(dao.pwCheck(idx, pw)) {
			System.out.println("수정 전 비밀번호와 동일합니다.");
			return;
		}
		
		dao.modifyMemberPw(idx,pw);
		
	}
	
}
