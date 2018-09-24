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

	public void increaseBoredom() {
		boredom += 1;
	}
	public void play() {
		boredom -= 5;
	}
}
