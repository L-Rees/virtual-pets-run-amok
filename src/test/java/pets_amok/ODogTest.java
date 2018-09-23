package pets_amok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ODogTest {
	
	ODog odog = new ODog("name", 10,10,3,4);

	@Test 
	public void shouldRenderODogProperties() {
		String dogName = odog.getName();
		int dogBoredom = odog.getBoredom();
		int dogWellBeing = odog.getWellBeing();
		int dogHunger = odog.getHunger();
		int dogThirst = odog.getThirst();
		assertThat(dogName, is("name"));
		assertThat(dogBoredom, is(10));
		assertThat(dogWellBeing, is(10));
		assertThat(dogHunger, is(3));
		assertThat(dogThirst, is(4));
	}
	
	@Test
	public void walkShouldDecreaseBoredom() {
		int dogBoredomBefore = odog.getBoredom();
		odog.walk();
		int dogBoredomAfter = odog.getBoredom();
		assertThat(dogBoredomBefore - dogBoredomAfter, is(5));
	}
	
	@Test
	public void hungerShouldDecreaseWithFeeding() {
		int dogHungerBefore = odog.getHunger();
		odog.feed();
		int dogHungerAfter = odog.getHunger();
		assertThat(dogHungerBefore - dogHungerAfter, is(5));
	}
	
	@Test
	public void thirstShouldDecreaseWithWatering() {
		int dogThirstBefore = odog.getThirst();
		odog.water();
		int dogThirstAfter = odog.getThirst();
		assertThat(dogThirstBefore -dogThirstAfter, is(5));
	}
	
	@Test
	public void thirstShouldIncreaseWithWalking() {
		int dogThirstBefore = odog.getThirst();
		odog.walk();
		int dogThirstAfter = odog.getThirst();
		assertThat(dogThirstAfter -dogThirstBefore, is(3));
	}
	
	@Test
	public void hungerShouldIncreaseWithWalking() {
		int dogHungerBefore = odog.getHunger();
		odog.walk();
		int dogHungerAfter = odog.getHunger();
		assertThat(dogHungerAfter - dogHungerBefore, is(3));
	}
	@Test
	public void boredomShouldDecreaseWithPlay() {
		int dogBoredomBefore = odog.getBoredom();
		odog.play();
		int dogBoredomAfter = odog.getBoredom();
		assertThat(dogBoredomBefore - dogBoredomAfter, is(5));
	}
	@Test
	public void poopChanceShouldBe0AfterWalking() {
		int poopChanceBefore = odog.getPoopChance();
		odog.walk();
		int poopChanceAfter = odog.getPoopChance();
		assertThat(poopChanceBefore - poopChanceAfter, is(1));
	}
	@Test
	public void poopChanceShouldResetTo1() {
		odog.walk();
		int poopChanceAfterWalk = odog.getPoopChance();
		odog.resetPoopChance();
		int poopChanceAfterReset = odog.getPoopChance();
		assertThat(poopChanceAfterReset - poopChanceAfterWalk, is(1));
	}
	
}



