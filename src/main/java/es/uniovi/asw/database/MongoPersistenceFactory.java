package es.uniovi.asw.database;

public class MongoPersistenceFactory {

	public static AgentDao getCitizenDao() {
		return new AgentDaoImplMongo();
	}

}
