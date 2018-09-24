package pets_amok;

public class RCat extends RoboticPet {

	public RCat(String name, int boredom, int wellBeing, int chargeLevel, int rustLevel) {
		this.name = name;
		this.boredom = boredom;
		this.wellBeing = wellBeing;
		this.chargeLevel = chargeLevel;
		this.rustLevel = rustLevel;
	}
	public RCat(String name) {
		this.name = name;
		boredom = 1;
		wellBeing = 10;
		chargeLevel = 10;
		rustLevel = 1;
	}

}
