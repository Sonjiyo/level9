package _06Zombie;

import java.util.*;

public class _gameMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();

		Hero hero = new Hero(1, 200, 20, 2,"히어로");
		Zombie zom = new Zombie(5, 100, 10,"좀비");

		// pos,hp,max,shield
		Boss boss = new Boss(9, 300, 20,"보스", 100);

		int pos = 1;
		// hero.setPos(pos);
		while (true) {

			if (hero.isDead())
				break;
			System.out.println("현재 위치 = " + pos);

			System.out.print("앞으로 이동하기(1),종료하기(2) ");

			int move = s.nextInt();

			if (move == 1) {
				hero.setPos(++pos);

				if (hero.getPos() == zom.getPos()) {

					System.out.println("좀비를 만났습니다. 공격모드로 바뀝니다. ");

					while (true) {
						int sel = 0;
						try {
							System.out.print("공격하기(1),포션마시기(2): ");
							sel = s.nextInt();
							if (sel < 1 || sel > 2) {
								System.out.println("입력 오류");
								continue;
							}
						} catch (Exception e) {
							s.nextLine();
							System.out.println("입력 오류");
							continue;
						}
						zom.attack(hero);
						if (sel == 1) {
							hero.attack(zom);
						} else {
							hero.hpRecovery();
						}
						if (zom.isDead())
							break;
						if (hero.isDead())
							break;
						//zom.hpRecovery();
					}
				}
				if (hero.getPos() == boss.getPos()) {

					System.out.println("보스를 만났습니다. 공격모드로 바뀝니다. ");
					while (true) {
						int sel = 0;
						try {
							System.out.print("공격하기(1),포션마시기(2): ");
							sel = s.nextInt();
							if (sel < 1 || sel > 2) {
								System.out.println("입력 오류");
								continue;
							}
						} catch (Exception e) {
							s.nextLine();
							System.out.println("입력 오류");
							continue;
						}
						boss.attack(hero);
						if (sel == 1) {
							hero.attack(boss);
						} else {
							hero.hpRecovery();
						}
						if (boss.isDead())
							break;
						if (hero.isDead())
							break;
					}
				}
				if (hero.getPos() == 10) {
					System.out.println("게임에서 승리했습니다. 종료합니다.");
					break;
				}

			} else if (move == 2) {
				break;
			}

		}
	}
}
