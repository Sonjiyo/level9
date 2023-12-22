package ploy_game;

public class Player extends Unit {
	Player(String na, int max, int pow) {
		super(na, max, pow);
	}

	void skill() {
		if(getName().equals("전사")) {
			
		} else if(getName().equals("마법사")) {
			
		} else if(getName().equals("힐러")) {
			
		}
	}

	@Override
	protected boolean skill(Unit target) {
		// TODO Auto-generated method stub
		return false;
	}

}