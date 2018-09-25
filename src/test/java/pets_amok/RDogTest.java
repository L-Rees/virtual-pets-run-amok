package pets_amok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RDogTest {

	RDog rdog = new RDog("name", 10, 9, 8,7, "description");
	
	@Test
	public void shouldRenderRDogProperties() {
		String rdogName = rdog.getName();
		int rdogBoredom = rdog.getBoredom();
		int rdogWellBeing = rdog.getWellBeing();
		int rdogChargeLevel = rdog.getChargeLevel();
		int rdogRustLevel = rdog.getRustLevel();
		assertThat(rdogName, is("name"));
		assertThat(rdogBoredom, is(10));
		assertThat(rdogWellBeing, is(9));
		assertThat(rdogChargeLevel, is(8));
		assertThat(rdogRustLevel, is(7));
	}
	
	@Test
	public void boredomShouldDecreaseWithPlayBy5() {
		int boredomBefore = rdog.getBoredom();
		rdog.play();
		int boredomAfter = rdog.getBoredom();
		assertThat(boredomBefore - boredomAfter, is(5));
	}
	@Test
	public void chargeLevelShouldIncreaseWithChargingBy8() {
		int chargeLevelBefore = rdog.getChargeLevel();
		rdog.charge();
		int chargeLevelAfter = rdog.getChargeLevel();
		assertThat(chargeLevelAfter - chargeLevelBefore, is(8));
	}
	@Test
	public void rustLevelShouldDecreaseWithOiling() {
		int rustBefore = rdog.getRustLevel();
		rdog.oil();
		int rustAfter = rdog.getRustLevel();
		assertThat(rustBefore-rustAfter, is(7));
	}
	@Test
	public void boredomAndRustShouldDecreaseWithWalking() {
		int boredomBefore = rdog.getBoredom();
		int rustBefore = rdog.getRustLevel();
		rdog.walk();
		int boredomAfter = rdog.getBoredom();
		int rustAfter = rdog.getRustLevel();
		assertThat(boredomBefore - boredomAfter, is(5));
		assertThat(rustBefore - rustAfter, is (5));
		
	}
	
}
