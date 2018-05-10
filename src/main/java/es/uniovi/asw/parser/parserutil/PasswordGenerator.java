package es.uniovi.asw.parser.parserutil;

import java.util.Set;

import es.uniovi.asw.agents.Agent;

public class PasswordGenerator {
	private final static String passCharacters = "0123456789ABCDEFGHIJKLMNOP"
			+ "QRSTUVWXYZabcdefghijklmnopqrstuvwxyz$-_¡!?¿@";
	private final static int passLength = 12;
	
	public static void createPasswords(Set<Agent> census) {
		for(Agent a: census) {
			a.setPassword("123456");
		}
	}

}
