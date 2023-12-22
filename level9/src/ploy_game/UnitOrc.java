package ploy_game;

public class UnitOrc extends Unit {
	UnitOrc() {setName("오크");}
	@Override
	public boolean skill(Unit target) {
		//"💫기절"
		if(Util.getRandomNum(0, 4)==0) {
			target.setState("💫기절");
			System.out.println("[오크] 가 " + "[" + target.getName() + "] 에게 [기절 스킬] 사용");
			setPower(getPower()*2);
			attack(target);
			setPower(getPower()/2);
			return true;
		}
		return false;
	}

}