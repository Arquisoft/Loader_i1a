package es.uniovi.asw.parser.parserutil;

import java.util.Random;
import java.util.Set;

import es.uniovi.asw.agents.Agent;

public class PasswordGenerator {
	private final static String passCharacters = "0123456789ABCDEFGHIJKLMNOP"
			+ "QRSTUVWXYZabcdefghijklmnopqrstuvwxyz$-_¡!?¿@";
	private final static int passLength = 12;
	
	public static void createPasswords(Set<Agent> census) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(passLength);
		for(Agent a: census) {
			for (int i = 0; i < passLength; i++) {
				sb.append(passCharacters
						.charAt(rnd.nextInt(passCharacters.length())));
			}
			a.setPassword(sb.toString());
		}
	}

}
