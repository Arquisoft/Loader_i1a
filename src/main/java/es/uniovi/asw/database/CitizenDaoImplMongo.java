package es.uniovi.asw.database;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import es.uniovi.asw.agents.Agent;
import es.uniovi.asw.reportwriter.WriteReport;
import es.uniovi.asw.reportwriter.WriteReportDefault;

/**
 * DAO implementation for MongoDB database
 * 
 * @author Roberto
 *
 */
public class CitizenDaoImplMongo implements CitizenDao {


	private MongoClient mongo;
	private DB db;
	private DBCollection users;
	private WriteReport reporter;
	private Properties properties;

	/**
	 * Default constructor that initializes the database from the constants
	 * specified above
	 */
	@SuppressWarnings("deprecation")
	public CitizenDaoImplMongo() {
		
		if (loadProperties()) {

			this.reporter = new WriteReportDefault();
			this.mongo = new MongoClient(properties.getProperty("host"), Integer
					.parseInt(properties.getProperty("port")));
			this.db = mongo.getDB(properties.getProperty("database"));
			this.users = db.getCollection(properties.getProperty("collection"));

			users.createIndex(new BasicDBObject("id", 1), new BasicDBObject(
					"unique", true));
		}
	}

	/**
	 * Loads the database properties file
	 * 
	 * @return True if we could load the file without problems, false otherwise
	 */
	private boolean loadProperties() {
		try {
			FileInputStream input = new FileInputStream("src/main/resources/database.properties");
			this.properties = new Properties();
			this.properties.load(input);
			return true;
		} catch (Exception e) {
			reporter.report(e, "Error loading database.properties file");
			return false;
		}
	}

	/**
	 * This method is used in the test (for using the database for test)
	 * 
	 * 
	 * @param host
	 * @param port
	 * @param database
	 * @param collection
	 */
	@SuppressWarnings("deprecation")
	public CitizenDaoImplMongo(String host, int port, String database,
			String collection) {
		this.reporter = new WriteReportDefault();
		this.mongo = new MongoClient(host, port);
		this.db = mongo.getDB(database);
		this.users = db.getCollection(collection);

		users.createIndex(new BasicDBObject("id", 1), new BasicDBObject(
				"unique", true));
	}

	/**
	 * 
	 * @param a
	 * 
	 *            Inserts a new document into the database with the citizen
	 *            passed as a parameter.
	 * 
	 */

	@Override
	public boolean insert(Agent a) {
		BasicDBObject document = new BasicDBObject();
		document.put("name", a.getName());
		document.put("email", a.getEmail());
		document.put("password", a.getPassword());
		document.put("location", a.getLocation());
		document.put("id", a.getID());
		document.put("kind", a.getKind());
		try {
			users.insert(document);
			reporter.logDatabaseInsertion(a);
			return true;
		} catch (DuplicateKeyException me) {
			reporter.report(me, "Error inserting in the database: "
					+ "The inserted Key is in the database");
		} catch (MongoException me) {
			reporter.report(me, "Error inserting in the database");
		}
		return false;

	}

	/**
	 * 
	 * @param ID
	 * 
	 *            Removes a document from the database.
	 * 
	 */

	@Override
	public void remove(String ID) {
		BasicDBObject document = new BasicDBObject();
		document.put("id", ID);
		users.remove(document);
	}

	/**
	 * 
	 * @param ID
	 * 
	 *            Returns a document (citizen) from the database corresponding
	 *            to the id passed as a parameter.
	 * 
	 */

	@Override
	public Agent findById(String ID) {
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("id", ID);
		DBCursor cursor = users.find(whereQuery);
		Agent a = null;
		while (cursor.hasNext()) {
			DBObject user = cursor.next();
			a = new Agent((String) user.get("name"), (String) user.get("location"),
					(String) user.get("email"),
					 (String) user.get("id"),
					(int) user.get("kind"), (String) user.get("password"));
		}
		return a;
	}

	/**
	 * 
	 * Returns every document (citizen) in the databse.
	 * 
	 */

	@Override
	public List<Agent> findAll() {

		List<Agent> allCitizens = new ArrayList<>();

		DBCursor cursor = users.find();
		while (cursor.hasNext()) {
			DBObject user = cursor.next();
			Agent a = new Agent((String) user.get("name"), (String) user.get("location"),
					(String) user.get("email"),
					(String) user.get("id"),
					(int) user.get("kind"), (String) user.get("password"));
			allCitizens.add(a);
		}

		return allCitizens;
	}

	/**
	 * 
	 * Clears the database.
	 * 
	 */

	@Override
	public void cleanDatabase() {
		users.remove(new BasicDBObject());

	}

}
