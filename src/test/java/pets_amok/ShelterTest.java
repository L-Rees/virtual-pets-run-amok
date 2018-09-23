package pets_amok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class ShelterTest {

	@Test
	public void shouldAddOrgDogToTheShelter() {
		Shelter underTest = new Shelter();
		ODog odog = new ODog("Rover", 1,2,3,4);
		underTest.putODog(odog.getName(), odog);
		Collection<ODog> allODogs = underTest.getAllODogs();
		assertThat(allODogs.size(), is(1));
	}
	
	
	
	
	
}
