package _11클렉션Member;

public class ActionFileSave implements Action {

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		FileManager.fileSave(dao.memberDataSave());
		System.out.println("[저장 완료]");
	}

}
