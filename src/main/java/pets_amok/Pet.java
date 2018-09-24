package pets_amok;

public class Pet {
	protected int boredom;
	protected String name;
	protected int wellBeing;

	public int getBoredom() {
		return boredom;
	}

	public String getName() {
		return name;
	}

	public int getWellBeing() {
		return wellBeing;
	}
	public void increaseWellBeing(int amount) {
		wellBeing += amount;
	}
	public void decreaseWellBeing(int amount) {
		wellBeing -= amount;
	}
	public void increaseBoredom() {
		boredom += 1;
	}
	public void play() {
		boredom -= 5;
		wellBeing +=5;
	}
	
}

