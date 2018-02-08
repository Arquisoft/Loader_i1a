package parsertests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import es.uniovi.asw.agents.Agent;
import org.junit.Test;

import es.uniovi.asw.parser.parserutil.PasswordGenerator;

public class PasswordTest {

	@Test
	public void testNotNull() {

		Agent a = new Agent("a", "Oviedo", "b@a.com", "2", 1);
		Set<Agent> census = new HashSet<Agent>();
		census.add(a);
		PasswordGenerator.createPasswords(census);
		assertTrue(a.getPassword() != null);

		PasswordGenerator pass = new PasswordGenerator();
		assertNotNull(pass);
	}

}
