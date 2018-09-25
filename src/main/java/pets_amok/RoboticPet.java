package pets_amok;

public class RoboticPet extends Pet {

	protected int chargeLevel;
	protected int rustLevel;

	public RoboticPet() {
		super();
	}

	public int getChargeLevel() {
		return chargeLevel;
	}

	public int getRustLevel() {
		return rustLevel;
	}

	public void charge() {
		chargeLevel += 8;
		wellBeing += 5;
	}

	public void oil() {
		rustLevel -= 7;
		wellBeing += 3;
	}

	public void increaseRust() {
		rustLevel += 4;
	}

	public void decreaseCharge() {
		chargeLevel -= 4;
	}

}