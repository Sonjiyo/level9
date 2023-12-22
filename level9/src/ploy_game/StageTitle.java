package ploy_game;

public class StageTitle implements Stage {

	@Override
	public boolean update() {
		System.out.println("======== TEXT RPG ========");
		System.out.println("[시작] 을 입력하세요");
		String start = Util.getValue("입력");
		if (start.equals("시작")) {
			GameManager.setNextStage("LOBBY");
			return false;
		} else {
			System.out.println("[입력 오류]");
			return true;
		}
	}

	@Override
	public void init() {

	}

}