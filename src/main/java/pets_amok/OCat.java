package pets_amok;

public class OCat extends OrganicPet {

	public OCat(String name, int boredom, int wellBeing, int hunger, int thirst) {
		this.name = name;
		this.boredom = boredom;
		this.wellBeing = wellBeing;
		this.hunger = hunger;
		this.thirst = thirst;

	}

	@Override
	public int poop() {
		int semiRandomPoopAmount = (int) (Math.random() * 3) + 1;
		return semiRandomPoopAmount;		
	}

}
