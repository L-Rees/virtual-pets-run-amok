package pets_amok;

public class Cage {

	private int cageSoilLevel;

	public void poopInCage(int amount) {
		cageSoilLevel += amount;
	}

	public int getCageSoilLevel() {
		return cageSoilLevel;
	}

	public void clean() {
		cageSoilLevel = 0;

	}
}
