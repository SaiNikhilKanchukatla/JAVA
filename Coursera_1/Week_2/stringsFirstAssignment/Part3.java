/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team 
 */
//import edu.duke.*;
import java.io.*;

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        int lastIndex = stringb.lastIndexOf(stringa);

        if (firstIndex != lastIndex) {
            return true;
        } else {
            return false;
        }
    }

    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);

        if (index == -1) {
            return stringb;
        } else {
            return stringb.substring(index + stringa.length());
        }
    }

    public void test() {
        String stringa;
        String stringb;

        System.out.println("Testing twoOccurences");
        stringa = "by";
        stringb = "A story by Abby Long";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));

        stringa = "a";
        stringb = "banana";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));

        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));

        System.out.println("\n\nTesting lastPart:");

        stringa = "an";
        stringb = "banana";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));

        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));
    }
}