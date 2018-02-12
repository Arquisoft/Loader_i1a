package parsertests;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import org.assertj.core.util.Files;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import es.uniovi.asw.agents.Agent;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.parser.readers.TxtReadList;

public class TxtParseTest {

	private Set<Agent> readData;

	@Before
	public void clearDatabase() {
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("Citizens");
		db.getCollection("users").deleteMany(new Document());
	}

	@Test
	public void testParse() {
		clearDatabase();
		String resultSt = "[Agent [name=jorge, email=jorge@email.es, "
				+ "location=18:13:14:12S, ID=ID4, kind=1]]";
		String resultTravis = "[Agent [name=jorge, email=jorge@email.es, "
				+ "location=18:13:14:12S, ID=ID4, kind=1]]";
		ReadList rl = new TxtReadList();
		readData = rl.parse("src/test/resources/test.txt");
		assertTrue(readData.toString().equals(resultSt)
				|| readData.toString().equals(resultTravis));

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

		ReadList rl = new TxtReadList();
		readData = rl.parse("src/test/resources/test4.txt");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel doesn't have a
	 * name
	 *
	 */
	@Test
	public void testNoLocation() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new TxtReadList();
		readData = rl.parse("src/test/resources/test5.txt");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel doesn't have a
	 * name
	 *
	 */
	@Test
	public void testNoEmail() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new TxtReadList();
		readData = rl.parse("src/test/resources/test6.txt");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel doesn't have a
	 * name
	 *
	 */
	@Test
	public void testNoID() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new TxtReadList();
		readData = rl.parse("src/test/resources/test7.txt");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the excel doesn't have a
	 * name
	 *
	 */
	@Test
	public void testNoKind() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new TxtReadList();
		readData = rl.parse("src/test/resources/test8.txt");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the txt has a blank row
	 * 
	 */
	@Test
	public void testNoRow() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new TxtReadList();
		readData = rl.parse("src/test/resources/test10.txt");

		assertTrue(file.exists());
		Files.delete(file);
	}

	/**
	 * Checks that the report file is generated when the citizen is duplicated
	 * 
	 */
	@Test
	public void testDuplicate() {
		SimpleDateFormat formatofilename = new SimpleDateFormat("dd-MM-yyyy",
				Locale.getDefault());
		String filename = formatofilename.format(new Date()) + ".txt";
		File file = new File(filename);

		ReadList rl = new TxtReadList();
		readData = rl.parse("src/test/resources/test9.txt");

		assertTrue(file.exists());
		Files.delete(file);
	}

}
