package pets_amok;

import java.util.Collection;
import java.util.HashMap;

public class Shelter {
	HashMap<String, ODog> oDogs = new HashMap<String, ODog>();
	HashMap<String, OCat> oCats = new HashMap<String, OCat>();
	HashMap<String, RDog> rDogs = new HashMap<String, RDog>();
	HashMap<String, RCat> rCats = new HashMap<String, RCat>();
	HashMap<String, Cage> cages = new HashMap<String, Cage>();

	private int litterboxSoilLevel;
	private int adoptedPetCount;

	public int getLitterboxSoilLevel() {
		return litterboxSoilLevel;
	}

	public void putODog(String name, ODog odog) {
		oDogs.put(name, odog);
		cages.put(name, new Cage());
	}

	public Collection<ODog> getAllODogs() {
		return oDogs.values();
	}

	public void putOCat(String name, OCat ocat) {
		oCats.put(name, ocat);
	}

	public Collection<OCat> getAllOCats() {
		return oCats.values();
	}

	public void putRDog(String name, RDog rdog) {
		rDogs.put(name, rdog);
	}

	public Collection<RDog> getAllRDogs() {
		return rDogs.values();
	}

	public void putRCat(String name, RCat rcat) {
		rCats.put(name, rcat);
	}

	public Collection<RCat> getAllRCats() {
		return rCats.values();
	}

	public Collection<Cage> getAllCages() {
		return cages.values();
	}

	public void feedAllOrganicPets() {
		for (OCat ocat : getAllOCats()) {
			ocat.feed();
		}
		for (ODog odog : getAllODogs()) {
			odog.feed();
		}
		System.out.println("All the organic animals in the shelter have full tummies.");
	}

	public void waterAllOrganicPets() {
		for (OCat ocat : getAllOCats()) {
			ocat.water();
		}
		for (ODog odog : getAllODogs()) {
			odog.water();
		}
		System.out.println("All the organic animals in the shelter have quenched their thirst.");
	}

	public void chargeAllRoboticPets() {
		for (RCat rcat : getAllRCats()) {
			rcat.charge();
		}
		for (RDog rdog : getAllRDogs()) {
			rdog.charge();
		}
		System.out.println("The robotic pets in the shelter have been recharged.");
	}

	public void oilAllRoboticPets() {
		for (RCat rcat : getAllRCats()) {
			rcat.oil();
		}
		for (RDog rdog : getAllRDogs()) {
			rdog.oil();
		}
		System.out.println("The robotic pets in the shelter have been oiled.");
	}

	public void cleanLitterbox() {
		litterboxSoilLevel = 0;
		for (OCat ocat : oCats.values()) {
			ocat.increaseWellBeing(3);
		}
		System.out.println("The organic cats in the shelter are pleased that you have finally done your duty.");
	}

	public void increasePoop() {
		if (oCats.size() > 0) {
			for (OCat ocat : getAllOCats()) {
				litterboxSoilLevel += ocat.poopAmount();
			}
		}
		if (oDogs.size() > 0) {
			for (ODog odog : getAllODogs()) {
				cages.get(odog.getName()).poopInCage(odog.poopAmount() * odog.getPoopChance());
			}
		}
	}

	public int getCageSoilLevel(String name) {
		int soilLevel = cages.get(name).getCageSoilLevel();
		return soilLevel;
	}

	public void cleanAllCages() {
		for (Cage cage : getAllCages()) {
			cage.clean();
		}
		System.out.println("All the organic dogs in the shelter have had their cages cleaned.");
	}

	public void playWithPet(String name) {
		if (oDogs.containsKey(name)) {
			oDogs.get(name).play();
			System.out.println(
					name + " is so very happy you played with them. " + name + " is a good dog! Yes they are!");
		} else if (oCats.containsKey(name)) {
			oCats.get(name).play();
			System.out.println(
					name + " is pleased that even a puny human such as yourself was able to see their majesty.");
		} else if (rDogs.containsKey(name)) {
			rDogs.get(name).play();
			System.out.println(name + "'s circuits exhibit increased activity after human interaction.");
		} else if (rCats.containsKey(name)) {
			rCats.get(name).play();
			System.out.println(name
					+ " has added its observations of your behavior to its records. Soon it will have enough data. Soon.");
		} else {
			System.out.println("There is no pet by that name in the shelter.");
		}
	}

	// if this is true, app should prompt for a different name on intake.
	public boolean nameCheck(String name) {
		return (rDogs.containsKey(name) || rCats.containsKey(name) || oDogs.containsKey(name)
				|| oCats.containsKey(name));
	}

	public void adoptpet(String name) {
		if (oDogs.containsKey(name)) {
			oDogs.remove(name);
			cages.remove(name);
			adoptedPetCount++;
		} else if (oCats.containsKey(name)) {
			oCats.remove(name);
			adoptedPetCount++;
		} else if (rDogs.containsKey(name)) {
			rDogs.remove(name);
			adoptedPetCount++;
		} else if (rCats.containsKey(name)) {
			rCats.remove(name);
			adoptedPetCount++;
		} else {
			System.out.println("There is no pet in the shelter by that name.");
		}
	}

	public int getAdoptedPetCount() {
		return adoptedPetCount;
	}

	public void tick() {
		increaseAllRust();
		decreaseAllCharge();
		increaseAllHunger();
		increaseAllThirst();
		increaseAllBoredom();
		increasePoop();
		checkWellBeing();
		resetODogsPoopChance();
	}

	private void resetODogsPoopChance() {
		for (ODog odog : oDogs.values()) {
			odog.resetPoopChance();
		}
	}

	private void checkWellBeing() {

		// check poop level of litterbox, +- all cats' wellbeing
		// check poop level in cages, +- the corresponding dog's wellbeing
		// check boredom, thirst, and hunger in opets, +- each's wellbeing
		// check boredom, rust, and charge in rpets, +- each's wellbeing

		if (getLitterboxSoilLevel() > 8) {
			for (OCat ocat : oCats.values()) {
				ocat.decreaseWellBeing(4);
			}
		} else if (getLitterboxSoilLevel() > 6) {
			for (OCat ocat : oCats.values()) {
				ocat.decreaseWellBeing(2);
			}
		} else if (getLitterboxSoilLevel() <= 3) {
			for (OCat ocat : oCats.values()) {
				ocat.increaseWellBeing(4);
			}
		}
		for (ODog odog : oDogs.values()) {
			int dirtiness = getCageSoilLevel(odog.getName());
			int hungriness = odog.getHunger();
			int boredness = odog.getBoredom();
			int thirstiness = odog.getThirst();
			int modifier = (thirstiness + boredness + hungriness - dirtiness) / 2;
			odog.decreaseWellBeing(modifier);
		}
		for (OCat ocat : oCats.values()) {
			int hungriness = ocat.getHunger();
			int boredness = ocat.getBoredom();
			int thirstiness = ocat.getThirst();
			int modifier = (thirstiness + boredness + hungriness) / 2;
			ocat.decreaseWellBeing(modifier);
		}
		for (RDog rdog : rDogs.values()) {
			int boredness = rdog.getBoredom();
			int rustiness = rdog.getRustLevel();
			int power = rdog.getChargeLevel();
			int modifier = (boredness + rustiness - (power / 2)) / 2;
			rdog.decreaseWellBeing(modifier);
		}
		for (RCat rcat : rCats.values()) {
			int boredness = rcat.getBoredom();
			int rustiness = rcat.getRustLevel();
			int power = rcat.getChargeLevel();
			int modifier = (boredness + rustiness - (power / 2)) / 2;
			rcat.decreaseWellBeing(modifier);
		}
	}

	private void increaseAllBoredom() {
		for (ODog odog : getAllODogs()) {
			odog.increaseBoredom();
		}
		for (OCat ocat : getAllOCats()) {
			ocat.increaseBoredom();
		}
		for (RDog rdog : getAllRDogs()) {
			rdog.increaseBoredom();
		}
		for (RCat rcat : getAllRCats()) {
			rcat.increaseBoredom();
		}
	}

	private void increaseAllThirst() {
		for (ODog odog : getAllODogs()) {
			odog.increaseThirst();
		}
		for (OCat ocat : getAllOCats()) {
			ocat.increaseThirst();
		}

	}

	private void increaseAllHunger() {
		for (ODog odog : getAllODogs()) {
			odog.increaseHunger();
		}
		for (OCat ocat : getAllOCats()) {
			ocat.increaseHunger();
		}
	}

	private void decreaseAllCharge() {
		for (RDog rdog : getAllRDogs()) {
			rdog.decreaseCharge();
		}
		for (RCat rcat : getAllRCats()) {
			rcat.decreaseCharge();
		}
	}

	private void increaseAllRust() {
		for (RDog rdog : getAllRDogs()) {
			rdog.increaseRust();
		}
		for (RCat rcat : getAllRCats()) {
			rcat.increaseRust();
		}
	}

	public int getRustLevel(String name) {
		if (rDogs.containsKey(name)) {
			return rDogs.get(name).getRustLevel();
		} else {
			return rCats.get(name).getRustLevel();
		}
	}

	public int getChargeLevel(String name) {
		if (rDogs.containsKey(name)) {
			return rDogs.get(name).getChargeLevel();
		} else {
			return rCats.get(name).getChargeLevel();
		}
	}

	public int getHungerLevel(String name) {
		if (oDogs.containsKey(name)) {
			return oDogs.get(name).getHunger();
		} else {
			return oCats.get(name).getHunger();
		}
	}

	public int getThirstLevel(String name) {
		if (oDogs.containsKey(name)) {
			return oDogs.get(name).getThirst();
		} else {
			return oCats.get(name).getThirst();
		}
	}

	public int getBoredomLevel(String name) {
		if (oDogs.containsKey(name)) {
			return oDogs.get(name).getBoredom();
		} else if (oCats.containsKey(name)) {
			return oCats.get(name).getBoredom();
		} else if (rDogs.containsKey(name)) {
			return rDogs.get(name).getBoredom();
		} else {
			return rCats.get(name).getBoredom();
		}
	}

	String mainMenu = "\n\nPlease choose an option below" + "\n1  Feed all the organic pets"
			+ "\n2  Water all the organic pets" + "\n3  Play with an individual pet"
			+ "\n4  Charge the batteries of all the robotic pets" + "\n5  Oil all the robotic pets"
			+ "\n6  Clean all the organic dogs' cages" + "\n7  Clean the organic cats' litterbox"
			+ "\n8  Admit a new pet to the shelter" + "\n9  Adopt a pet out of the shelter" + "\n10  Exit the shelter";

	String typeMenu = "\n1  Robotic Dog" + "\n2  Organic Dog" + "\n3  Robotic Cat" + "\n4  Organic Cat";

	public void importpets() {
		rDogs.put("Poochie", new RDog("Poochie", "Tries to be cool"));
		rCats.put("Scratchy", new RCat("Scratchy", "A big bug-eyed"));
		oDogs.put("Santos L Halper", new ODog("Santos L Halper", "Dumb but loyal"));
		cages.put("Santos L Halper", new Cage());
		oCats.put("Snowball II", new OCat("Snowball II", "Black as night"));

	}

	public void putNamedRDog(String nameInput, String descriptionInput) {
		rDogs.put(nameInput, new RDog(nameInput, descriptionInput));
	}

	public void putNamedODog(String nameInput, String descriptionInput) {
		oDogs.put(nameInput, new ODog(nameInput, descriptionInput));
		cages.put(nameInput, new Cage());
	}

	public void putNamedRCat(String nameInput, String descriptionInput) {
		rCats.put(nameInput, new RCat(nameInput, descriptionInput));
	}

	public void putNamedOCat(String nameInput, String descriptionInput) {
		oCats.put(nameInput, new OCat(nameInput, descriptionInput));
	}

	public String getRDogList() {
		String list = "";
		for (RDog rdog : rDogs.values()) {
			list += rdog.getName() + "\t" + rdog.getDescription() + "\n";
		}
		return list;
	}

	public String getODogList() {
		String list = "";
		for (ODog odog : oDogs.values()) {
			list += odog.getName() + "\t" + odog.getDescription() + "\n";
		}
		return list;
	}

	public String getRCatList() {
		String list = "";
		for (RCat rcat : rCats.values()) {
			list += rcat.getName() + "\t" + rcat.getDescription() + "\n";
		}
		return list;
	}

	public String getOCatList() {
		String list = "";
		for (OCat ocat : oCats.values()) {
			list += ocat.getName() + "\t" + ocat.getDescription() + "\n";
		}
		return list;
	}

	public String shelterStatus() {
		String status = "\n\n\t\t\t\tPetStatus\n";
		if (rDogs.size() > 0) {
			status += "\nRobotic Dogs\n" + "\nName\t\tWell-Being\tBoredom\t\tBattery\t\tRustiness";
			for (RDog rdog : rDogs.values()) {
				status += "\n" + stringFix(rdog.getName()) + "\t" + showLevel(rdog.getWellBeing()) + "\t"
						+ showLevel(rdog.getBoredom()) + "\t" + showLevel(rdog.getChargeLevel()) + "\t"
						+ showLevel(rdog.getRustLevel());
			}
		} else {
			status += "You do not have any robotic dogs";
		}
		if (rCats.size() > 0) {
			status += "\n\n______________\nRobotic Cats" + "\nName\t\tWell-Being\tBoredom\t\tBattery\t\tRustiness";
			for (RCat rcat : rCats.values()) {
				status += "\n" + stringFix(rcat.getName()) + "\t" + showLevel(rcat.getWellBeing()) + "\t"
						+ showLevel(rcat.getBoredom()) + "\t" + showLevel(rcat.getChargeLevel()) + "\t"
						+ showLevel(rcat.getRustLevel());
			}
		} else {
			status += "\nYou do not have any robotic cats";
		}
		if (oDogs.size() > 0) {
			status += "\n\n______________\nOrganic Dogs"
					+ "\nName\t\tWell-Being\tBoredom\t\tHunger\t\tThirst\t\tCage Soil Level";
			for (ODog odog : oDogs.values()) {
				status += "\n" + stringFix(odog.getName()) + "\t" + showLevel(odog.getWellBeing()) + "\t"
						+ showLevel(odog.getBoredom()) + "\t" + showLevel(odog.getHunger()) + "\t"
						+ showLevel(odog.getThirst()) + "\t" + showLevel(getCageSoilLevel(odog.getName()));
			}
		} else {
			status += "\nYou do not have any organic dogs";
		}
		if (oCats.size() > 0) {
			status += "\n\n______________\nOrganic Cats\t\tLitterbox Soil Level   " + showLevel(getLitterboxSoilLevel())
					+ "\nName\t\tWell-Being\tBoredom\t\tHunger\t\tThirst";
			for (OCat ocat : oCats.values()) {
				status += "\n" + stringFix(ocat.getName()) + "\t" + showLevel(ocat.getWellBeing()) + "\t"
						+ showLevel(ocat.getBoredom()) + "\t" + showLevel(ocat.getHunger()) + "\t"
						+ showLevel(ocat.getThirst());
			}
		} else {
			status += "\nYou do not have any organic cats";
		}

		return status;
	}

	public String showLevel(int quality) {
		String level = "";
		for (int i = 0; i < quality; i++) {
			level = level + "|";
		}
		for (int i = 0; i < 10 - quality; i++) {
			level = level + ".";
		}
		return level.substring(0, 10);

		// good-||||......-bad
	}

	public String stringFix(String name) {
		String newString = name;
		if (name.length() < 15) {
			for (int x = 0; x < 15 - name.length(); x++) {
				newString += " ";
			}
		} else {
			newString = name.substring(0, 15);
		}
		return newString;
	}

}
