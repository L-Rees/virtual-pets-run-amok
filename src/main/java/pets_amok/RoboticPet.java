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
	}

	public void oil() {
		rustLevel -= 7;		
	}
	public void increaseRust() {
		rustLevel +=1;
	}
	public void decreaseCharge() {
		chargeLevel -= 2;
	}
	

}