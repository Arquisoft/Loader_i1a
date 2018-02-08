package lettergeneratorstests;

import static org.junit.Assert.*;

import java.io.File;

import es.uniovi.asw.agents.Agent;
import org.assertj.core.util.Files;
import org.junit.Test;

import es.uniovi.asw.parser.lettergenerators.PDFLetterGenerator;

public class PDFGeneratorTest {

	@Test
	public void testGeneratePDF() {
		PDFLetterGenerator pdfg = new PDFLetterGenerator();

		Agent a = new Agent("Roberto", "Gijón",
				"robertops1818@gmail.com", "53778998F", 1);
		pdfg.generatePersonalLetter(a);
		File f = new File(a.getID() + ".pdf");
		assertTrue(f.exists());
		Files.delete(f);

	}

}
