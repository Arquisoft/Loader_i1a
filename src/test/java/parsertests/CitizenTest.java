package parsertests;

import static org.junit.Assert.*;

import es.uniovi.asw.agents.Agent;
import org.junit.Test;

public class CitizenTest {

	@Test
	public void testEquals() {
		Agent dummy = new Agent("a", "b", "a@a.com", "10/10/2010", "a", "a",
				"123456789Z", "132456789", 1234);
		Agent dummy1 = new Agent("b", "c", "b@a.com", "10/10/2010", "a",
				"a", "123456789Z", "132456789", 1234);
		Agent dummy2 = new Agent("a", "b", "b@a.com", "10/10/2010", "a",
				"a", "3", "132456789", 1234);
		Agent dummy3 = null;
		Agent dummy4 = new Agent("a", "b", "b@a.com", "10/10/2010", "a",
				"a", null, "132456789", 1234);
		Agent dummy5 = new Agent("a", "b", "b@a.com", "10/10/2010", "a",
				"a", null, "132456789", 1234);
		Double doub = new Double(5.0);

		assertTrue(dummy.equals(dummy));
		assertTrue(dummy.equals(dummy1));
		assertFalse(dummy.equals(dummy2));
		assertFalse(dummy.equals(dummy3));
		assertFalse(dummy4.equals(dummy1));
		assertFalse(dummy.equals(doub));
		assertTrue(dummy4.equals(dummy5));
	}

}
