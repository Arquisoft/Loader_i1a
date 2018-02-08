package es.uniovi.asw.database;

import java.util.List;

import es.uniovi.asw.agents.Agent;

/**
 * Interface for the methods that the DAO must accomplish
 * 
 * @author Gonzalo de la Cruz Fernández - UO244583
 *
 */
public interface CitizenDao {

	boolean insert(Agent c);

	Agent findById(String ID);

	void remove(String ID);

	List<Agent> findAll();

	void cleanDatabase();
}
