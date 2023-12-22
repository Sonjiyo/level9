package ploy_game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class StageBattle implements Stage {
	private UnitManager unitManager = new UnitManager();
	private ArrayList<Player> playerList = null;
	private ArrayList<Unit> monList = null;
	private int monDead = 0;
	private int playerDead = 0;

	public void init() {
		unitManager.monster_rand_set(4);
		playerList = null;
		playerList = unitManager.getPlayer_list();
		monList = null;
		monList = unitManager.getMon_list();
		monDead = monList.size();
		playerDead = playerList.size();
	}

	private void print_character() {
		// System.out.println(playerSize + " " + monSize);
		System.out.println("==========[PLAYER]==========");
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("==========[MONSTER]=========");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}

	private void player_attack(int index) {
		Player p = playerList.get(index);
		if(unitManager.isUnitFaint(p)) return;
		if (p.getCurhp() <= 0)
			return;
		System.out.println("==========[메뉴 선택]=========");
		while(true) {
			System.out.println("[" + p.getName() + "] [1.어택] [2.스킬]");
			int sel = Util.getValue("입력", 1, 2);
			if (sel == 1) {
				while (true) {
					int idx = Util.getRandomNum(0, monList.size()); 
					
					if (monList.get(idx).getCurhp() > 0) {
						p.attack(monList.get(idx));
						break;
					}
				}
			} else if (sel == 2) {
				if(unitManager.isUnitSilence(p)) {
					System.out.println("[침묵 상태로 스킬 사용 불가능]");
					continue;
				}
				int idx = Util.getRandomNum(0, monList.size());
				p.skill(monList.get(idx));
			}
			break;
		}
	}

	private void monster_attack(int index) {
		Unit m = monList.get(index);
		if(unitManager.isUnitFaint(m)) return;
		if (m.getCurhp() <= 0)
			return;
		while (true) {
			int idx = Util.getRandomNum(0, playerList.size()); 

			if (playerList.get(idx).getCurhp() > 0) {
				boolean check = false;
				if(!unitManager.isUnitSilence(m)) {
					check = m.skill(playerList.get(idx));
				}
				if(!check) {
					m.attack(playerList.get(idx));															
				}else if(m instanceof UnitWolf) {
					for(Player p : playerList) {
						m.attack(p);
					}
				}
				break;
			}
		}
	}

	private void check_live() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getCurhp() <= 0) {
				num += 1;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).getCurhp() <= 0) {
				num += 1;
			}
		}
		monDead = monList.size() - num;

	}

	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;
		System.out.println("==========[BATTLE]==========");
		while (run) {
			// print_character();
			if (turn) {
				print_character();
				if (p_index < playerList.size()) {
					player_attack(p_index);

					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}

			} else if (!turn) {
				if (m_index < monList.size()) {
					monster_attack(m_index);
					m_index += 1;
				} else {
					turn = !turn;
					m_index = 0;
				}
			}
			check_live();
			if (monDead <= 0 || playerDead <= 0)
				break;
		}
		GameManager.setNextStage("LOBBY");
		return false;
	}
}