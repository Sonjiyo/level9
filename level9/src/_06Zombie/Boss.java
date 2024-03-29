package _06Zombie;

import java.util.*;

//Boss 클래스는 Zombie 클래스를 상속받는다.
//Boss 클래스는 보호막 shield 멤버변수를 가진다.
//공격 메소드 void attack( Unit enemy ) 
//일반공격 : 1~공격력(max) 사이의 랜덤 값을 공격력으로 사용하여 enemy의 체력 감소시킴 (출력 예 : “보스가 15 의 공격력으로 일반 공격 : 현재 Hero의 hp는 25”)
//필살기 : 25%의 확률로 1~max 사이의 공격력의 2배 만큼으로 상대를 공격하는 기능 (출력 예 : “보스가 30 의 공격력으로 필살기 공격 : 현재 Hero의 hp는 25”)
//Boss 클래스는 생성자를 가짐(현재위치, 체력,공격력, 보호막)

public class Boss extends Zombie {
	private int power;

	private int shield;
	public Boss(int pos, int hp, int max,String name, int shield) {
		super(pos, hp, max,name);
		this.shield = shield;
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
		if(this.shield<0) {
			setHp(getHp()+this.shield);
			this.shield= 0;
		}
	}

	@Override
	boolean attack(Unit unit) {
		power = ((Boss)this).bossAttackUp() ? getRandom(getMax()*2) : getRandom(getMax());

		unit.setHp(unit.getHp()-power);
		System.out.println("보스가 "+power+"의 데미지로 공격 / 히어로의 현재 체력 "+unit.getHp());
		return unit.isDead();
	}
	
	boolean bossAttackUp() {
		if(getRandom(4)==1) {
			System.out.println("[ 보스 필살기 발동 2배의 공격력 ]");
			return true;
		}else {
			System.out.println("[ 보스 일반 공격 ]");
			return false;
		}
	}
}