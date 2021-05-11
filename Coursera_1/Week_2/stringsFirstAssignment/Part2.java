/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team 
 */

import java.io.*;
public class Part2 {
	public String findSimpleGene(String dna, String startCodon, String stopCodon) {
		String result = "Not Valid";

		int startIndex = dna.toUpperCase().indexOf(startCodon);
		int stopIndex = dna.toUpperCase().indexOf(stopCodon, startIndex + 3);

		if (startIndex == -1 || stopIndex == -1) {
			return result;
		}

		if ((stopIndex - startIndex) % 3 == 0) {
			result = dna.substring(startIndex, stopIndex + 3);
		}

		return result;
	}

	public void testSimpleGene() {
		String startCodon = "ATG";
		String stopCodon = "TAA";

		// DNA with no ATG
		String dna = "ATCTAACATC";
		System.out.println("DNA strand is " + dna);
		System.out.println("Gene is " + findSimpleGene(dna, startCodon,stopCodon));

		// DNA with no TAA
		dna = "ATTATCATGTTA";
		System.out.println("DNA strand is " + dna);
		System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));

		dna = "ATTAGTGTA";
		System.out.println("DNA strand is " + dna);
		System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));

		dna = "GAAATGGATAGTAA";
		System.out.println("DNA strand is " + dna);
		System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));

		dna = "TAAGATATGGTGAAGTAA";
		System.out.println("DNA strand is " + dna);
		System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));

		dna = "ATGGGTTAAGTC";
		System.out.println("DNA strand is " + dna);
		System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));

		dna = "gatgctataat";
		System.out.println("DNA strand is " + dna);
		System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
	}
}

