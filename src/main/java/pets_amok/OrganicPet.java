package pets_amok;

public class OrganicPet extends Pets {

	protected int thirst;
	protected int hunger;
	public OrganicPet() {
		super();
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public void feed() {
		hunger -= 5;
		thirst += 3;
	}

	public void water() {
		thirst -= 5;
	}

}