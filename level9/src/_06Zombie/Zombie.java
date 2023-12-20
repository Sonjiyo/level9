package _06Zombie;

import java.util.Random;

// 좀비는 히어로 공격 가능하고 한턴이 지날때마다 본인 power의 50%를 회복하는 능력을 가지고 있다 
public class Zombie extends Unit {
	private int power;
	
	public Zombie(int pos,int hp,int max, String name) {
		super(pos,hp,max,name);
	}

	@Override
	boolean attack(Unit unit) {
		power = getRandom(getMax());
		unit.setHp(unit.getHp()-power);
		System.out.println("좀비가 "+power+"의 데미지로 공격 / 히어로의 현재 체력 "+unit.getHp());
		hpRecovery();
		return false;
	}
	
	void hpRecovery() {
		setHp(getHp()+power/2);
	}
}