package es.uniovi.asw.parser;

import es.uniovi.asw.agents.Agent;

import java.util.Set;

/**
 * @author Oriol
 * 
 */
public interface ReadList {
	Set<Agent> parse(String ruta);
}
