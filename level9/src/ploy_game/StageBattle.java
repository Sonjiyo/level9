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
	private int cnt;

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
		if (p.getCurhp() <= 0)
			return;
		if(p.isStateEffect()) p.setState("노말");
		if(unitManager.isUnitFaint(p) || unitManager.isUnitSilence(p)) {
			p.setStateEffect(true);
		}
		if(unitManager.isUnitFaint(p)) {
			System.out.println("["+p.getName()+"] 기절 상태로 공격 불가능");
			return;
		}
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
				boolean check = false;
				if(unitManager.isUnitSilence(p)) {
					System.out.println("[침묵 상태로 스킬 사용 불가능]");
					continue;
				}
				if(!p.getName().equals("힐러")) {
					while(true) {
						int idxM = Util.getRandomNum(0, monList.size());
						if(monList.get(idxM).getCurhp()>0) {
							check = p.skill(monList.get(idxM));
							break;
						} 
					}					
				} else {
					int cnt = 0;
					while(true) {
						int idxP = Util.getRandomNum(0, playerList.size());
						if(playerList.get(idxP).getCurhp()!=playerList.get(idxP).getMaxhp()
								&& playerList.get(idxP).getCurhp()>0) {
							check = p.skill(playerList.get(idxP));
							break;
						}
						cnt++;
						if(cnt>20) {
							System.out.println("[회복 가능한 대상이 없습니다.]");
							break;
						}
					}
				}
				if(!check) continue;
			}
			break;
		}
	}

	private void monster_attack(int index) {
		Unit m = monList.get(index);
		if (m.getCurhp() <= 0)
			return;
		if(unitManager.isUnitFaint(m)) return;
		if(m.isStateEffect()) m.setState("노말");
		if(unitManager.isUnitFaint(m) || unitManager.isUnitSilence(m)) {
			m.setStateEffect(true);
		}
		if(unitManager.isUnitFaint(m)) {
			System.out.println("["+m.getName()+"] 기절 상태로 공격 불가능");
			return;
		}
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
					int power = m.getPower();
					m.setPower(power/2);
					for(Player p : playerList) {
						if(p.getCurhp()==0) continue;
						m.attack(p);
					}
					m.setPower(power);
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
				if (p_index < playerList.size()) {
					print_character();
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
		for(Player p : playerList) {
			p.setSkillCnt(2);
		}
		if(playerDead<=0) {
			GameManager.setNextStage("");
			return false;
		}
		GameManager.setNextStage("LOBBY");
		return false;
	}
}