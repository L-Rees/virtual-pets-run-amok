package pets_amok;

public abstract class Pet {
	
	protected int boredom;
	protected String name;
	protected int wellBeing;
	protected String description;

	public int getBoredom() {
		return boredom;
	}

	public String getDescription() {
		return description;
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
		wellBeing += 5;
	}

}
