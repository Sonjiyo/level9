package ploy_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class UnitManager {

	private ArrayList<Player> player_list = new ArrayList<>();
	private ArrayList<Unit> mon_list = new ArrayList<>();
	private String path = UnitManager.class.getPackageName()+"."; // 패키지명 + .
	private String mons[] = { "UnitWolf", "UnitBat", "UnitOrc" };

	public ArrayList<Player> getPlayer_list() {
		return player_list;
	}

	public ArrayList<Unit> getMon_list() {
		return mon_list;
	}
	
	public UnitManager() {
		player_list.add(new Player("전사", 100, 45));
		player_list.add(new Player("마법사", 80, 60));
		player_list.add(new Player("힐러", 50, 70));
	}

	public void monster_rand_set(int size) {
		mon_list.clear();
		for (int i = 0; i < size; i++) {
			int num = Util.getRandomNum(0, mons.length); 

			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance(); // clazz.newInstance();
				Unit temp = (Unit) obj;
				int hp = Util.getRandomNum(100, 100);
				int pow = Util.getRandomNum(10, 10);
				temp.init(hp, pow);
				mon_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println(mon_list.get(i).name);
		}
	}
	
	public boolean isUnitFaint(Unit unit) {
		if(unit.getState().equals("💫기절")) return true;
		return false;
	}
	
	public boolean isUnitSilence(Unit unit) {
		if(unit.getState().equals("❌침묵")) return true;
		return false;
	}
}