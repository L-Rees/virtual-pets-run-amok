package pets_amok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

public class ShelterTest {

	Shelter underTest = new Shelter();
	RCat rcat = new RCat("Scratchy", 10, 10, 10, 10);
	ODog odog = new ODog("Rover", 10, 10, 10, 10);
	OCat ocat = new OCat("Fluffy", 10, 10, 10, 10);
	RDog rdog = new RDog("Rusty", 10, 10, 10, 10);

	@Test
	public void shouldAddOrgDogToTheShelter() {
		underTest.putODog(odog.getName(), odog);
		Collection<ODog> allODogs = underTest.getAllODogs();
		assertThat(allODogs.size(), is(1));
	}

	@Test
	public void shouldAddOrgCatToTheShelter() {
		underTest.putOCat(ocat.getName(), ocat);
		Collection<OCat> allOCats = underTest.getAllOCats();
		assertThat(allOCats.size(), is(1));
	}

	@Test
	public void shouldAddRoboDogToShelter() {
		underTest.putRDog(rdog.getName(), rdog);
		Collection<RDog> allRDogs = underTest.getAllRDogs();
		assertThat(allRDogs.size(), is(1));
	}

	@Test
	public void shouldAddRoboCatToShelter() {
		underTest.putRCat(rcat.getName(), rcat);
		Collection<RCat> allRCats = underTest.getAllRCats();
		assertThat(allRCats.size(), is(1));
	}

	@Test
	public void shouldFeedOCat() {
		underTest.putOCat(ocat.getName(), ocat);
		int hungerBefore = ocat.getHunger();
		underTest.feedAllOrganicPets();
		int hungerAfter = ocat.getHunger();
		assertThat(hungerBefore - hungerAfter, is(5));
	}
	@Test
	public void shouldOilRCat() {
		underTest.putRCat(rcat.getName(), rcat);
		int rustBefore = rcat.getRustLevel();
		underTest.oilAllRoboticPets();
		int rustAfter = rcat.getRustLevel();
		assertThat(rustBefore - rustAfter, is(7));
	}
	
	@Test
	public void litterboxSoilLevelShouldIncrease() {
		underTest.putOCat(ocat.getName(), ocat);
		int litterboxBefore = underTest.getLitterboxSoilLevel();
		underTest.increasePoop();
		underTest.increasePoop();
		int litterboxAfter = underTest.getLitterboxSoilLevel();
		assertTrue(litterboxAfter > litterboxBefore);
	}
	
	@Test
	public void shouldCleanLitterBox() {
		underTest.putOCat(ocat.getName(), ocat);
		underTest.increasePoop();
		underTest.cleanLitterbox();
		int litterboxAfter = underTest.getLitterboxSoilLevel();
		assertThat(litterboxAfter, is(0));
	}
	
	@Test
	public void ODogsShouldHaveACage() {
		underTest.putODog(odog.getName(), odog);
		Collection<Cage> cages = underTest.getAllCages();
		assertThat(cages.size(), is(1));
	}
	
	@Test
	public void ODogsShouldPoopInTheirCages() {
		underTest.putODog(odog.getName(), odog);
		int cageBefore = underTest.getCageSoilLevel(odog.getName());
		underTest.increasePoop();
		int cageAfter = underTest.getCageSoilLevel(odog.getName());
		assertTrue(cageAfter > cageBefore);
	}
	
	@Test
	public void cagesShouldGetCleaner() {
		underTest.putODog(odog.getName(), odog);
		underTest.increasePoop();
		underTest.increasePoop();
		underTest.cleanAllCages();
		int cageAfter = underTest.getCageSoilLevel(odog.getName());
		assertThat(cageAfter, is(0));
	}
	@Test
	public void shouldBeAbleToAdoptAPet() {
		underTest.putODog(odog.getName(), odog);
		underTest.adoptpet(odog.getName());
		Collection<ODog> odogs = underTest.getAllODogs();
		assertThat(odogs.size(), is(0));
	}
	@Test
	public void rustLevelIncreasesWithTick() {
		underTest.putRCat(rcat.getName(), rcat);
		underTest.tick();
		int check = underTest.getRustLevel(rcat.getName());
		assertThat(check, is(11));
	}
	@Test
	public void chargeLevelDecreasesWithTick() {
		underTest.putRCat(rcat.getName(), rcat);
		underTest.tick();
		int check = underTest.getChargeLevel(rcat.getName());
		assertThat(check, is(8));
	}
	@Test
	public void hungerShouldIncreaseWithTick() {
		underTest.putODog(odog.getName(), odog);
		underTest.tick();
		int check = underTest.getHungerLevel(odog.getName());
		assertThat(check, is(11));
	}
	@Test
	public void thirstShouldIncreaseWithTick() {
		underTest.putODog(odog.getName(), odog);
		underTest.tick();
		int check = underTest.getThirstLevel(odog.getName());
		assertThat(check, is(11));
	}
	@Test
	public void boredomShouldIncreaseWithTick() {
		underTest.putODog(odog.getName(), odog);
		underTest.tick();
		int check = underTest.getBoredomLevel(odog.getName());
		assertThat(check, is(11));
	}
	
	
}
