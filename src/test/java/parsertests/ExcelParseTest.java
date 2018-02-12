package parsertests;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import es.uniovi.asw.agents.Agent;
import org.assertj.core.util.Files;
import org.junit.Test;

import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.parser.readers.ExcelReadList;

public class ExcelParseTest {

	private Set<Agent> readData;

	@Test
	public void testParse() {
		String result = "[Agent [name=jorge, email=jorge@email.es, "
				+ "location=18:13:14:12S, ID=ID4, kind=1]]";
		String resultForTravis = "[Agent [name=jorge, email=jorge@email.es, "
				+ "location=18:13:14:12S, ID=ID4, kind=1]]";

		ReadList rl = new ExcelReadList();
		readData = rl.parse("src/test/resources/test2.xlsx");

		assertTrue(readData.toString().equals(result)
				|| readData.toString().equals(resultForTravis));
	}

	@Test
	/**
	 * Checks whether the file exists or not.
	 * 
	 */
	public void fileNotFound() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new ExcelReadList();
		readData = rl.parse("archivoQueNoExiste");

		assertTrue(file.exists());
		Files.delete(file);
	}


	/**
	 * Checks that the report file is generated when the excel doesn't have a
	 * name
	 * 
	 */
	@Test
	public void testNoName() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new ExcelReadList();
		readData = rl.parse("src/test/resources/test4.xlsx");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel doesn't have a
	 * surname
	 * 
	 */
	@Test
	public void testNoEmail() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new ExcelReadList();
		readData = rl.parse("src/test/resources/test5.xlsx");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel doesn't have a
	 * birthdate
	 * 
	 */
	@Test
	public void testNoLocation() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new ExcelReadList();
		readData = rl.parse("src/test/resources/test6.xlsx");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel doesn't have the
	 * NIF
	 * 
	 */
	@Test
	public void testID() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new ExcelReadList();
		readData = rl.parse("src/test/resources/test7.xlsx");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel doesn't have an
	 * address
	 * 
	 */
	@Test
	public void testNoKind() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new ExcelReadList();
		readData = rl.parse("src/test/resources/test8.xlsx");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel has a blank row.
	 * 
	 */
	@Test
	public void testNoRow() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new ExcelReadList();
		readData = rl.parse("src/test/resources/test10.xlsx");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the citizen is duplicated
	 * 
	 */
	@Test
	public void testNoDuplicate() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new ExcelReadList();
		readData = rl.parse("src/test/resources/test9.xlsx");

		assertTrue(file.exists());
		Files.delete(file);
	}

}
