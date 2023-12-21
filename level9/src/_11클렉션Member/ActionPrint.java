package _11클렉션Member;

public class ActionPrint implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		System.out.println("===================");
		System.out.println("Id\tPw");
		System.out.println("===================");
		dao.printMember();
	}

}
