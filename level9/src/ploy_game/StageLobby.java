package ploy_game;

public class StageLobby implements Stage {
	@Override
	public boolean update() {
		System.out.println("==========[LOBBY]==========");
		System.out.println("[1.전투] [2.종료]");
		int sel = Util.getValue("입력", 1, 2);
		if (sel == 1) {
			GameManager.setNextStage("BATTLE");
		} else if (sel == 2) {
			GameManager.setNextStage("");
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}