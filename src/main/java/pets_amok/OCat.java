package pets_amok;

public class OCat extends OrganicPet {

	public OCat(String name, int boredom, int wellBeing, int hunger, int thirst) {
		this.name = name;
		this.boredom = boredom;
		this.wellBeing = wellBeing;
		this.hunger = hunger;
		this.thirst = thirst;
	}
	public OCat(String name) {
		this.name = name;
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
