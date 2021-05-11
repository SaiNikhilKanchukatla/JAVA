/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team
 */
//import edu.duke.*;
import edu.duke.*;
import java.io.*;


public class Part1 {
	public int findStopCodon(String dna, int startIndex, String stopCodon) {
		int index = 0;

		while(true) {
			index = dna.toUpperCase().indexOf(stopCodon, startIndex + 3);

			if (index == -1 || (index - startIndex) % 3 == 0) {
				break;
			}

			startIndex += 3;
		}

		if (index != -1) {
			return index;
		} else {
			return dna.length();
		}
	}

	public void testFindStopCodon() {
		String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";

		int index = findStopCodon(dna, 0, "TAA");
		System.out.println("Index = " + index);

		index = findStopCodon(dna, 9, "TAA");
		System.out.println("Index = " + index);

		index = findStopCodon(dna, 1, "TAA");
		System.out.println("Index = " + index);

		index = findStopCodon(dna, 0, "TAG");
		System.out.println("Index = " + index);
	}

	public String findGene(String dna, int start) {
		final String START_CODON = "ATG";
		int startIndex = dna.toUpperCase().indexOf(START_CODON, start);

		if (startIndex == -1) {
			return "";
		}

		int taaIndex = findStopCodon(dna, startIndex, "TAA");
		int tagIndex = findStopCodon(dna, startIndex, "TAG");
		int tgaIndex = findStopCodon(dna, startIndex, "TGA");

		int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));

		if (minIndex == dna.length()) {
			return "";
		} else {
			return dna.substring(startIndex, minIndex + 3);
		}
	}

	public void testFindGene() {
		String dna = "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
		System.out.println("Gene: " + findGene(dna, 0));

		dna = "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
		System.out.println("Gene: " + findGene(dna, 0));

		dna = "TTTCAGTGAGCTTACACATGCAAGTATCCGCGCGCCAGTGAAAATGCCCT";
		System.out.println("Gene: " + findGene(dna, 0));

		dna = "TCAAATCATTACTGACCATAAAGGAGCGGGTATCAAGCACACACCTATGT";
		System.out.println("Gene: " + findGene(dna, 0));

		dna = "AGCTCACAACACCTTGCTTAGCCACACCCCCACGGGATACAGCAGTGATA";
		System.out.println("Gene: " + findGene(dna, 0));
	}

	public StorageResource getAllGenes(String dna) {
		int start = 0;
		StorageResource geneList = new StorageResource();

		while (true) {
			String gene = findGene(dna, start);

			if (gene.isEmpty()) {
				break;
			}

			geneList.add(gene);

			start = dna.indexOf(gene, start) + gene.length();
		}

		return geneList;
	}

	public void testGetAllGenes() {
		String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
		StorageResource geneList = getAllGenes(dna);

		System.out.println("Testing getAllGenes on " + dna);
		for(String gene : geneList.data()) {
			System.out.println("Gene: " + gene);
		}
	}
}

class Main{
	public static void main(String args[]){
		System.out.println("part 1");
		Part1 object = new Part1();
		object.testGetAllGenes();



		System.out.println("part 2");
		Part2 object2 = new Part2();
		object2.testCountCTG();
		object2.testcgRatio();


		System.out.println("part 3");
		Part3 object3 = new Part3();
		object3.testProcessGenes();

	}
}