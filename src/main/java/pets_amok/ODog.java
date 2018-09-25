package pets_amok;

public class ODog extends OrganicPet  implements Walkies {

	private int poopChance = 1;  //will be 0 if walked, 1 if they weren't. resets to 1 at tick.

	
	public int getPoopChance() {
		return poopChance;
	}
	public ODog(String name, int boredom, int wellBeing, int hunger, int thirst, String description) {
		this.name = name;
		this.boredom = boredom;
		this.wellBeing = wellBeing;
		this.hunger = hunger;
		this.thirst = thirst;
		this.description = description;
	}
	public ODog(String name, String description) {
		this.name = name;
		this.description = description;
		boredom = 1;
		wellBeing = 10;
		hunger = 1;
		thirst = 1;
	}

	@Override
	public void walk() {
		boredom -= 5;
		thirst += 3;
		hunger += 3;
		poopChance = 0;
	}

	public void resetPoopChance() {
		poopChance = 1;
	}
	@Override
	public int poopAmount() {
		int semiRandomPoopAmount = (int) (Math.random() * 3) + 1;
		return semiRandomPoopAmount;
	}

}