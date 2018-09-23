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
		litterboxSoilLevel -= 10;
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
		
	public void playWithODog(String name) {
		oDogs.get(name).play();
	}
	public void playWithOCat(String name) {
		oCats.get(name).play();
	}
	public void playWithRCat(String name) {
		rCats.get(name).play();
	}
	public void playWithRDog(String name) {
		rDogs.get(name).play();
	}
		//if this is true, app should prompt for a different name on intake.
	public boolean nameCheck(String name) {
		return (rDogs.containsKey(name) && rCats.containsKey(name) && oDogs.containsKey(name) && oCats.containsKey(name));
	}

	public void adoptpet(String name) {
		if (oDogs.containsKey(name)) {
			oDogs.remove(name);
		}else if(oCats.containsKey(name)) {
			oCats.remove(name);
		}else if(rDogs.containsKey(name)) {
			rDogs.remove(name);
		}else if(rCats.containsKey(name)) {
			rCats.remove(name);
		}
		adoptedPetCount ++;
	}
	
	public int getAdoptedPetCount() {
		return adoptedPetCount;
	}

	public void tick() {
		increaseAllRust();
		
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
		}else {
			return rCats.get(name).getRustLevel();
		}
	}
}
