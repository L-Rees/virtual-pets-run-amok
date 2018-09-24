package pets_amok;

public abstract class OrganicPet extends Pet {

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
		wellBeing += 5;
	}

	public void increaseHunger() {
		hunger += 1;
	}

	public void increaseThirst() {
		thirst += 1;
	}

	public void water() {
		thirst -= 5;
		wellBeing +=3;
	}

	public abstract int poopAmount();
}