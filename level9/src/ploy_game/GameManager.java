package ploy_game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	private static String nextStage = "";
	private String curStage = "";
	private Map<String, Stage> stageList = new HashMap<String, Stage>();

	public static void setNextStage(String nextStage) {
		GameManager.nextStage = nextStage;
	}

	GameManager() {

		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());

		nextStage = "TITLE";
	}

	boolean changeStage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);

		if (curStage.equals(nextStage))
			return true;

		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();

		boolean run = true;
		while (true) {
			run = stage.update();
			if (run == false)
				break;
		}

		if (nextStage.equals(""))
			return false;
		else
			return true;
	}

}