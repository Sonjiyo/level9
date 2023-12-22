package ploy_game;

public class _MainGame {

	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		boolean run = true;
		while (run) {
			run = gameManager.changeStage();
		}
		System.out.println("게임오버");
	}
}