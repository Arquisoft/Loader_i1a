package lettergeneratorstests;

import static org.junit.Assert.assertTrue;

import java.io.File;

import es.uniovi.asw.agents.Agent;
import org.assertj.core.util.Files;
import org.junit.Test;

import es.uniovi.asw.parser.lettergenerators.WordLetterGenerator;

public class WordGeneratorTest {

	@Test
	public void test() {
		WordLetterGenerator wordg = new WordLetterGenerator();
		Agent c = new Agent("adri", "mc", "zoo@snek.com", "10/10/2010", "a",
				"a", "123456789Z", "132456789", 1234);
		wordg.generatePersonalLetter(c);
		File f = new File(c.getID() + ".docx");
		assertTrue(f.exists());
		Files.delete(f);
	}

}
