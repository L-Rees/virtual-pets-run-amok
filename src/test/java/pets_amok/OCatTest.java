package pets_amok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OCatTest {
	OrganicPet ocat = new OCat("name", 10, 9, 8, 7);

	@Test
	public void shouldRenderOCatProperties() {
		String catName = ocat.getName();
		int catBoredom = ocat.getBoredom();
		int catWellBeing = ocat.getWellBeing();
		int catHunger = ocat.getHunger();
		int catThirst = ocat.getThirst();
		assertThat(catName, is("name"));
		assertThat(catBoredom, is(10));
		assertThat(catWellBeing, is(9));
		assertThat(catHunger, is(8));
		assertThat(catThirst, is(7));
	}
	@Test
	public void feedingShouldDecreaseHungerBy5() {
		int catHungerBefore = ocat.getHunger();
		ocat.feed();
		int catHungerAfter = ocat.getHunger();
		assertThat(catHungerBefore -catHungerAfter, is(5));
	}
	@Test
	public void feedingShouldIncreaseThirstBy3() {
		int catThirstBefore = ocat.getThirst();
		ocat.feed();
		int catThirstAfter = ocat.getThirst();
		assertThat(catThirstAfter - catThirstBefore, is(3));
	}
	@Test
	public void thirstShouldDecreaseWithWateringBy5() {
		int catThirstBefore = ocat.getThirst();
		ocat.water();
		int catThirstAfter = ocat.getThirst();
		assertThat(catThirstBefore - catThirstAfter, is(5));
	}
	@Test
	public void boredomShouldDecreaseWithPlayBy5() {
		int catBoredomBefore = ocat.getBoredom();
		ocat.play();
		int catBoredomAfter = ocat.getBoredom();
		assertThat(catBoredomBefore - catBoredomAfter, is(5));
}
	
}
