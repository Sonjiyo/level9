package _11클렉션Member;

public class ActionInsert implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		//멤버 추가하는 페이지
		System.out.println("[멤버 추가하기]");
		String id = Util.getValue("아이디 입력");
		
		if(dao.isVaildId(id)!=-1) {
			System.out.println("이미 사용중인 아이디");
			return;
		}
		String pw = Util.getValue("비밀번호 입력");
		
		dao.insertMember(id,pw);
	}

}
