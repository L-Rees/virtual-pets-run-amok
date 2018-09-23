package pets_amok;

public class Pets {

	protected int wellBeing;
	protected int boredom;
	protected String name;

	public Pets() {
		super();
	}

	public String getName() {
		return name;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getWellBeing() {
		return wellBeing;
	}

	public void play() {
		boredom -= 5;
	
	}

}