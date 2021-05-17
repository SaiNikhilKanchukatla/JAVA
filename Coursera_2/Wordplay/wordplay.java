/**
 * Find the highest (hottest) temperature in any number of files of CSV weather data chosen by the user.
 * 
 * @author Duke Software Team 
 */

import java.io.*;

class Wordplay {
boolean isVowel(char ch){
	if (ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o') {
		return true;
	}
	return false;
}

public String replaceVowels(String phrase, char ch) {
	StringBuilder newPhrase = new StringBuilder();

	for (int i = 0; i < phrase.length(); i++) {
		char currentCharacter = phrase.charAt(i);

		if (isVowel(currentCharacter)) {
			newPhrase.append(ch);
		} else {
			newPhrase.append(currentCharacter);
		}
	}

	return newPhrase.toString();
}

	public String emphasize(String phrase, char ch) {
		StringBuilder newPhrase = new StringBuilder();
		for (int i = 0; i < phrase.length(); i++) {
			char currentCharacter = phrase.charAt(i);
			if (Character.toLowerCase(currentCharacter) == Character.toLowerCase(ch)) {
				if (i % 2 == 0) {
					newPhrase.append('*');
				} else {
					newPhrase.append('+');
				}
			} else {
				newPhrase.append(currentCharacter);
			}
		}

		return newPhrase.toString();
	}

}

class Main{
	public static void main(String args[])
	{
      Wordplay object = new Wordplay();
		System.out.println(object.replaceVowels("Hello World",'*'));
		System.out.println(object.emphasize("dna ctgaaactga",'a'));
	}
}