package _06Zombie;

import java.util.Random;

// 좀비는 히어로 공격 가능하고 한턴이 지날때마다 현재 체력의 50%를 회복하는 능력을 가지고 있다 
public class Zombie extends Unit {
	private int power;
	private Random rd = new Random();
	
	public Zombie(int pos,int hp,int max, String name) {
		super(pos,hp,max,name);
	}

	@Override
	boolean attack(Unit unit) {
		boolean check = false;
		if(this instanceof Boss) {
			check = ((Boss)this).bossAttackUp();
		}
		power = rd.nextInt(this.getMax())+1;
		unit.setHp(power*-1);
		System.out.println(this.getName()+"가 "+power+"의 데미지로 공격 / "+
				unit.getName()+"의 현재 체력 "+unit.getHp());
		if(check) this.setMax(this.getMax()/2);
		return false;
	}
	
	void hpRecovery() {
		this.setHp(this.getHp()/2);
	}
}