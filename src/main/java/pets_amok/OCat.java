package pets_amok;

public class OCat extends OrganicPet {

	public OCat(String name, int boredom, int wellBeing, int hunger, int thirst, String description) {
		this.name = name;
		this.boredom = boredom;
		this.wellBeing = wellBeing;
		this.hunger = hunger;
		this.thirst = thirst;
		this.description = description;
	}

	public OCat(String name, String description) {
		this.name = name;
		this.description = description;
		boredom = 1;
		wellBeing = 10;
		hunger = 1;
		thirst = 1;
	}

	@Override
	public int poopAmount() {
		int semiRandomPoopAmount = (int) (Math.random() * 3) + 1;
		return semiRandomPoopAmount;
	}

}
