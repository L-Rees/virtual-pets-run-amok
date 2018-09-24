package pets_amok;

public class RDog extends RoboticPet implements Walkies{

	public RDog(String name, int boredom, int wellBeing, int chargeLevel, int rustLevel) {
		this.name = name;
		this.boredom = boredom;
		this.wellBeing = wellBeing;
		this.chargeLevel = chargeLevel;
		this.rustLevel = rustLevel;
	}
	public RDog(String name) {
		this.name = name;
		boredom = 1;
		wellBeing = 10;
		chargeLevel = 10;
		rustLevel = 1;
	}
	
	@Override
	public void walk() {
		boredom -=5;
		rustLevel -=5;
	}
	
	

}
