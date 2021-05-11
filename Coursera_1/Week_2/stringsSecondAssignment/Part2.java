/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team 
 */

import java.io.*;
public class Part2 {
	public int howMany(String stringa, String stringb) {
		int totalOccurences = 0;
		int start = 0;

		while (true) {
			int index = stringb.indexOf(stringa, start);

			if (index == -1) {
				break;
			}

			totalOccurences++;
			start = index + stringa.length();
		}

		return totalOccurences;
	}

	public void testHowMany() {
		String stringa = "GAA";
		String stringb = "ATGAACGAATTGAATC";
		System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howMany(stringa, stringb));

		stringa = "AA";
		stringb = "ATAAAA";
		System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howMany(stringa, stringb));
	}
}