package pets_amok;

public class RDog extends RoboticPet implements Walkies{

	public RDog(String name, int boredom, int wellBeing, int chargeLevel, int rustLevel) {
		this.name = name;
		this.boredom = boredom;
		this.wellBeing = wellBeing;
		this.chargeLevel = chargeLevel;
		this.rustLevel = rustLevel;

	}
	@Override
	public void walk() {
		boredom -=5;
		rustLevel -=5;
	}
	
	

}
