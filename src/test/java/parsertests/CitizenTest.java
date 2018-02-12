package parsertests;

import static org.junit.Assert.*;

import es.uniovi.asw.agents.Agent;
import org.junit.Test;

public class CitizenTest {

	@Test
	public void testEquals() {

		Agent a = new Agent("Roberto", "Gijón",
				"robertops1818@gmail.com", "53778998F", 1);
		Agent dummy = new Agent("a", "Gijón", "a@a.com", "1", 1);
		Agent dummy1 = new Agent("b", "Oviedo", "b@a.com", "2", 1);
		Agent dummy2 = new Agent("c", "Oviedo", "b@a.com", "2", 1);
		Agent dummy3 = new Agent("b", "Oviedo", "b@a.com", "2", 1);
		Agent dummy4 = new Agent("a", "Oviedo", "b@a.com", "2", 1);
		Agent dummy5 = new Agent("a", "Oviedo", "b@a.com", "2", 1);
		Double doub = new Double(5.0);

		assertTrue(dummy.equals(dummy));
		assertFalse(dummy.equals(dummy1));
		assertFalse(dummy.equals(dummy2));
		assertFalse(dummy.equals(dummy3));
		assertFalse(dummy4.equals(dummy1));
		assertFalse(dummy.equals(doub));
		assertTrue(dummy4.equals(dummy5));
	}

}
