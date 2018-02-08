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
		Agent a = new Agent("Roberto", "Gijón",
				"robertops1818@gmail.com", "53778998F", 1);
		wordg.generatePersonalLetter(a);
		File f = new File(a.getID() + ".docx");
		assertTrue(f.exists());
		Files.delete(f);
	}

}
