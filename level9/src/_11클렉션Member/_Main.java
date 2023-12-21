package _11클렉션Member;

public class _Main {
	public static void main(String[] args) {
		Controller con = Controller.getInstance();
		
		while(true) {
			System.out.println("======= 메뉴 =======");
			System.out.println("1) 추가");
			System.out.println("2) 삭제");
			System.out.println("3) 수정");
			System.out.println("4) 출력(id 이름순으로 출력)");
			System.out.println("5) 데이터 저장");
			System.out.println("6) 데이터 불러오기");
			System.out.println("0) 종료");
			int sel = Util.getValue("입력", 0, 6);
			
			if(sel==0) break;
			if(sel==1) {
				con.getAction("insert").excute();
			} else if(sel==2) {
				con.getAction("delete").excute();
			} else if(sel==3) {
				con.getAction("modify").excute();
			} else if(sel==4){
				con.getAction("print").excute();
			} else if(sel==5) {
				con.getAction("save").excute();
			} else {
				con.getAction("load").excute();
			}
		}
	}
}
