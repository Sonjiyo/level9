package _06Zombie;

import java.util.Random;

// 보스인지 아닌지 구분해서 공격 

// 히어로는 체력 포션으로 100 체력 회복할 수 있고 체력 포션이 없으면 체력 회복이 안된다 
// 외부의 적은 보스인지 아닌지 구별해서 공격 해야한다 
// 보스이면 보호막을 가지고 있다 먼저 보호막을 다 뚫어야지만 직접 보스를 공격할 수 있다. 
// 일반 적은 보호막 가지고 있지 않음 

public class Hero extends Unit {
	private int power;
	private Random rd = new Random();
	private int count; //체력포션
	
	public Hero(int pos, int hp, int max, int count, String name) {
		super(pos, hp, max, name);
		this.count = count;
	}

	@Override
	boolean attack(Unit unit) {
		power = rd.nextInt(this.getMax())+1;
		if(unit instanceof Boss && ((Boss) unit).getShield()>0) {
			((Boss) unit).setShield(power*-1);
			if(((Boss) unit).getShield()<0) ((Boss) unit).resetShield();
			System.out.println(this.getName()+"가 "+power+"의 데미지로 공격 / "+
					((Boss) unit).getName()+"의 현재 방어 "+((Boss) unit).getShield());
			return false;
		}
		unit.setHp(power*-1);
		System.out.println(this.getName()+"가 "+power+"의 데미지로 공격 / "+
				unit.getName()+"의 현재 체력 "+unit.getHp());
		return false;
	}
	
	void hpRecovery() {
		if(count==0) {
			System.out.println("물약이 없습니다.");
			return;
		}
		this.setHp(100);
		count--;
	}

	
}