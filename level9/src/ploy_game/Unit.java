package ploy_game;

public abstract class Unit {
	private int curhp;
	private int maxhp;
	private int power;
	private String name;
	private String state = "노말";
	private boolean stateEffect;

	public int getCurhp() {
		return curhp;
	}
	public void setCurhp(int curhp) {
		this.curhp = curhp;
	}
	public int getMaxhp() {
		return maxhp;
	}
	public int getPower() {
		return power;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public void setPower(int power) {
		this.power = power;
	}
	public void setStateEffect(boolean stateEffect) {
		this.stateEffect = stateEffect;
	}
	public boolean isStateEffect() {
		return stateEffect;
	}
	Unit() {};

	public Unit(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	};

	public void init(int max, int pw) {
		maxhp = max;
		curhp = max;
		power = pw;
	};

	public void attack(Unit target) {
		target.curhp -= power;
		System.out.println("[" + name + "] 가 " + "[" + target.name + "] 에게 " + power + "의 데미지를 입힙니다. ");
		if (target.curhp <= 0) {
			System.out.println("[" + target.name + "] 가 사망했습니다.");
			target.curhp = 0;
			target.setState("노말");
		}
	}

	public void printData() {
		System.out.print("[" + name + "]\t🖤 " + curhp + "/" + maxhp + " \t⚔️" + power);
		System.out.println(state.equals("노말") ? "" : " "+state);
	}
	
	protected abstract boolean skill(Unit target);
}