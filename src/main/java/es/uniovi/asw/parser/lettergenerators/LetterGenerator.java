package es.uniovi.asw.parser.lettergenerators;

import es.uniovi.asw.agents.Agent;

/**
 * @author Oriol 
 * Strategy. 
 * Encapsulate output algorithm, in order to prepare: 
 * [Optional] The system could be extended to emit the letters 
 * using other formats like Microsoft Word or PDF.
 */
public interface LetterGenerator {
	void generatePersonalLetter(Agent c);
}
