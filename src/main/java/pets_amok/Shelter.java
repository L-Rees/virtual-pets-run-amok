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
	}

	public void waterAllOrganicPets() {
		for (OCat ocat : getAllOCats()) {
			ocat.water();
		}
		for (ODog odog : getAllODogs()) {
			odog.water();
		}
	}

	public void chargeAllRoboticPets() {
		for (RCat rcat : getAllRCats()) {
			rcat.charge();
		}
		for (RDog rdog : getAllRDogs()) {
			rdog.charge();
		}
	}

	public void oilAllRoboticPets() {
		for (RCat rcat : getAllRCats()) {
			rcat.oil();
		}
		for (RDog rdog : getAllRDogs()) {
			rdog.oil();
		}
	}

	public void cleanLitterbox() {
		litterboxSoilLevel = 0;
	}

	public void increasePoop() {
		for (OCat ocat : getAllOCats()) {
			litterboxSoilLevel += ocat.poop();
		}
		for (ODog odog : getAllODogs()) {
			if (odog.getPoopChance() == 1) {
				cages.get(odog.getName()).poopInCage(odog.getPoopChance() * odog.poop());
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
	}

	public void playWithPet(String name) {
		if (oDogs.containsKey(name)) {
			oDogs.get(name).play();
		}else if (oCats.containsKey(name)) {
			oCats.get(name).play();
		}else if (rDogs.containsKey(name)) {
			rDogs.get(name).play();
		}else if (rCats.containsKey(name)) {
			rCats.get(name).play();
		}
	}
	

	// if this is true, app should prompt for a different name on intake.
	public boolean nameCheck(String name) {
		return (rDogs.containsKey(name) && rCats.containsKey(name) && oDogs.containsKey(name)
				&& oCats.containsKey(name));
	}

	public void adoptpet(String name) {
		if (oDogs.containsKey(name)) {
			oDogs.remove(name);
		} else if (oCats.containsKey(name)) {
			oCats.remove(name);
		} else if (rDogs.containsKey(name)) {
			rDogs.remove(name);
		} else if (rCats.containsKey(name)) {
			rCats.remove(name);
		}
		adoptedPetCount++;
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
			int modifier = (boredness + rustiness - power) / 2;
			rdog.decreaseWellBeing(modifier);
		}
		for (RCat rcat : rCats.values()) {
			int boredness = rcat.getBoredom();
			int rustiness = rcat.getRustLevel();
			int power = rcat.getChargeLevel();
			int modifier = (boredness + rustiness - power) / 2;
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
	
	String mainMenu = "1  Feed all the organic pets" +
			"2  Water all the organic pets" +
			"3  Play with an individual pet" + 
			"4  Charge the batteries of all the robotic pets" +
			"5  Oil all the robotic pets" + 
			"6  Clean all the organic dogs' cages" +
			"7  Clean the organic cats' litterbox" +
			"8  Admit a new pet to the shelter"+
			"9  Adopt a pet out of the shelter"+
			"10  Exit the shelter";
	
	String typeMenu = 
			"\n1  Robotic Dog" +
			"\n2  Organic Dog" +
			"\n3  Robotic Cat"+
			"\n4  Organic Cat";

	public void importpets() {
		rDogs.put("Poochie", new RDog("Poochie"));
		rCats.put("Scratchy", new RCat("Scratchy"));
		oDogs.put("Santos L Halper", new ODog("Santos L Halper"));
		oCats.put("Snowball II", new OCat("Snowball II"));
		
	}

	public void putNamedRDog(String nameInput) {
		rDogs.put(nameInput, new RDog(nameInput));
	}

	public void putNamedODog(String nameInput) {
		oDogs.put(nameInput, new ODog(nameInput));
	}

	public void putNamedRCat(String nameInput) {
		rCats.put(nameInput, new RCat(nameInput));
	}

	public void putNamedOCat(String nameInput) {
		oCats.put(nameInput, new OCat(nameInput));
	}

	public String getRDogList() {
		String list = "";
		for (RDog rdog : rDogs.values()) {
			list += rdog.getName() + "\n";
		}
		return list;
	}
	public String getODogList() {
		String list = "";
		for (ODog odog : oDogs.values()) {
			list += odog.getName() + "\n";
		}
		return list;
	}
	public String getRCatList() {
		String list = "";
		for (RCat rcat : rCats.values()) {
			list += rcat.getName() + "\n";
		}
		return list;
	}
	
	public String getOCatList() {
		String list = "";
		for (OCat ocat : oCats.values()) {
			list += ocat.getName() + "\n";
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
}
