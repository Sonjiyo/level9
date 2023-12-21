package _11클렉션Member;

public class ActionFileLoad implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		String data = FileManager.fileLoad();
		dao.memberDataLoad(data);
	}

}
