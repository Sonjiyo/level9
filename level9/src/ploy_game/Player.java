package ploy_game;

public class Player extends Unit {
	private String chClass;
	Player(String na, int max, int pow, String chClass) {
		super(na, max, pow);
		this.chClass = chClass;
	}

	void skill() {
		if(chClass.equals("전사")) {
			
		} else if(chClass.equals("마법사")) {
			
		} else {
			
		}
	}

}