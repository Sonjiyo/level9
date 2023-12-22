package ploy_game;

public class UnitWolf extends Unit {
	UnitWolf() {setName("늑대");}
	@Override
	public boolean skill(Unit target) {
		if(Util.getRandomNum(0, 4)==0) {
			System.out.println("[늑대] 가 [전체 공격 스킬] 사용");
			return true;
		}
		return false;
	}

}