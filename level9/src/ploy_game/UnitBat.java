package ploy_game;

public class UnitBat extends Unit {
	public UnitBat() {setName("박쥐");}
	@Override
	public boolean skill(Unit target) {
		//"❌침묵"
		if(Util.getRandomNum(0, 4)==0) {
			System.out.println("[박쥐] 가 " + "[" + target.getName() + "] 에게 [침묵 스킬] 사용");
			target.setState("❌침묵");
			return true;
		}
		return false;
	}
}