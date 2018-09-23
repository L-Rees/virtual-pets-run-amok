package pets_amok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RCatTest {

	RoboticPet rcat = new RCat("name", 10, 9, 8, 7);
	
	@Test
	public void shouldHaveBoredomOf10() {
		int rcatboredom = rcat.getBoredom();
		assertThat(rcatboredom, is(10));
	}
}
