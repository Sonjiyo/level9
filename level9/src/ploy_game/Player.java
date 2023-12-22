package ploy_game;

public class Player extends Unit {
	private int skillCnt = 2;
	Player(String na, int max, int pow) {
		super(na, max, pow);
	}
	@Override
	protected boolean skill(Unit target) {
		if(skillCnt==0) {
			System.out.println("더이상 스킬을 사용할 수 없습니다.");
			return false;
		}
		if(getName().equals("전사")) {
			System.out.println("[전사 스킬 발동]");
			setPower(getPower()*2);
			attack(target);
			setPower(getPower()/2);
		} else if(getName().equals("마법사")) {
			target.setState("💫기절");
			System.out.println("[마법사] 가 "+target.getName()+"에게 [기절 스킬] 사용");
		} else if(getName().equals("힐러")) {
			//랜덤 아군 체력 100 회복
			System.out.println("[힐러] 가 "+target.getName()+"의 체력 100 회복");
			target.setCurhp(target.getCurhp()+100);
		}
		skillCnt--;
		return true;
	}
	public void setSkillCnt(int skillCnt) {
		this.skillCnt = skillCnt;
	}

	
}