package pets_amok;

import java.util.Collection;
import java.util.HashMap;

public class Shelter {
	HashMap <String, ODog> oDogs = new HashMap<String, ODog>();

	public void putODog(String name, ODog odog) {
		oDogs.put(name, odog);
	}

	public Collection<ODog> getAllODogs() {
		return oDogs.values();
	}
	
}
