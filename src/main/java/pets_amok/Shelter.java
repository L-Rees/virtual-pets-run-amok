package pets_amok;

import java.util.Collection;
import java.util.HashMap;

public class Shelter {
	HashMap <String, ODog> oDogs = new HashMap<String, ODog>();
	HashMap <String, OCat> oCats = new HashMap<String, OCat>();
	HashMap <String, RDog> rDogs = new HashMap<String, RDog>();
	HashMap <String, RCat> rCats = new HashMap<String, RCat>();
	HashMap <String, Cage> cages = new HashMap<String, Cage>();
	private int litterboxSoilLevel;
	
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
		for (OCat ocat : getAllOCats()){
			litterboxSoilLevel += ocat.poop();
		}
		for (ODog odog : getAllODogs()) {
			if (odog.getPoopChance() == 1) {
				cages.get(odog.getName()).poopInCage(odog.getPoopChance()*odog.poop());
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


	
	
	
	
	
	
}
