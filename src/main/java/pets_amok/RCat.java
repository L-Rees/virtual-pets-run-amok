package pets_amok;

public class RCat extends RoboticPet {

	public RCat(String name, int boredom, int wellBeing, int chargeLevel, int rustLevel, String description) {
		this.name = name;
		this.boredom = boredom;
		this.wellBeing = wellBeing;
		this.chargeLevel = chargeLevel;
		this.rustLevel = rustLevel;
		this.description = description;
	}
	public RCat(String name, String description) {
		this.name = name;
		this.description = description;
		boredom = 1;
		wellBeing = 10;
		chargeLevel = 10;
		rustLevel = 1;
	}

}
