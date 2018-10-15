package week1Capstonepackage;

import java.util.Scanner;

public class PigLatinTranslator3 {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		String userWord, continueProgram;

		System.out.println("===========================");
		System.out.println("SIMPLE PIG-LATIN TRANSLATOR");
		System.out.println("===========================");

		do { // The continue-quit do/while loop.
			System.out.println(" ");
			System.out.println("Please enter words to be translated:");
			// Scanner checks input for integers, and kicks out error message if any
			// exist:
			while (scnr.hasNextInt()) {
				userWord = scnr.next();
				System.out.println("ixNay on the Errorway, iendFray!");
				System.out.println("Please try again:");
				System.out.println(" ");
			}
			userWord = scnr.next();
			// Translator method call:
			System.out.println(translator(userWord));
			System.out.println(" ");
			System.out.println("Do you want to translate another line? (y/n)");
			continueProgram = scnr.next();
		} while (continueProgram.charAt(0) == 'y');

		System.out.println(" ");
		System.out.println("Very well. eeSay ouYay aterLay!");
		System.out.println(" ");
		scnr.close();

	}

	/*
	 * Here's my original translator method, unchanged since the end of class,
	 * Friday 10/12. Eclipse formatting removed the brackets once the block was
	 * commented out. Imagine as if they were in place:
	 * 
	 * if (oldWord.indexOf('a') == 0 || oldWord.indexOf('e') == 0 ||
	 * oldWord.indexOf('i') == 0 || oldWord.indexOf('o') == 0 ||
	 * oldWord.indexOf('u') == 0) { pigWord = oldWord + "way"; }
	 * 
	 * else if (oldWord.indexOf('a') == 1 || oldWord.indexOf('e') == 1 ||
	 * oldWord.indexOf('i') == 1 || oldWord.indexOf('o') == 1 ||
	 * oldWord.indexOf('u') == 1) { pigWord = oldWord.substring(1) +
	 * oldWord.charAt(0) + "ay"; }
	 * 
	 * else if (oldWord.indexOf('a') == 2 || oldWord.indexOf('e') == 2 ||
	 * oldWord.indexOf('i') == 2 || oldWord.indexOf('o') == 2 ||
	 * oldWord.indexOf('u') == 2) { pigWord = oldWord.substring(2) +
	 * oldWord.substring(0, 2) + "ay"; }
	 * 
	 * else if (oldWord.indexOf('a') == 3 || oldWord.indexOf('e') == 3 ||
	 * oldWord.indexOf('i') == 3 || oldWord.indexOf('o') == 3 ||
	 * oldWord.indexOf('u') == 3) { pigWord = oldWord.substring(3) +
	 * oldWord.substring(0, 3) + "ay"; } return pigWord;
	 * 
	 * It works for most words of the English language, because we couldn't think of
	 * any real words with more than three consonants up-front. And then I
	 * remembered the name "Pryzbelewski" from THE WIRE, where the first vowel
	 * occurs at index five!!! (Maybe that's one of the rare occurrences that 'y'
	 * may be considered a vowel...)
	 * 
	 * After being inspired by another classmate's code, which made my statements
	 * look rather cumbersome, I consulted Google to see what others had done to try
	 * and slim down their translators.
	 * 
	 * What follows is inspired by a program found at:
	 * http://eventfuljava.cs.williams.edu/sampleProgs/ch19/lectures/PigLatin/
	 * PigLatin.java
	 * 
	 * I'm certainly happy that I made a basic program that worked, before I
	 * consulted the methods of others.
	 */

	// This method defines what a vowel is. Uppercase is included.
	public static boolean vowelChar(char v) {
		return v == 'A' || v == 'E' || v == 'I' || v == 'O' || v == 'U' || v == 'a' || v == 'e' || v == 'i' || v == 'o'
				|| v == 'u';
	}

	// This method scans the string and returns the index of the first vowel it
	// finds.
	public static int firstVowel(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (vowelChar(word.charAt(i))) {
				return i;
			}
		}
		return -1;
	}

	// And finally the translator method!
	public static String translator(String oldWord) {

		String pigWord, prefix, suffix;
		int vowel = firstVowel(oldWord);

		pigWord = oldWord;

		if (vowel == -1) {
			return oldWord;
		} else if (vowel == 0) {
			return pigWord + "way";
		} else {
			prefix = oldWord.substring(0, vowel);
			suffix = oldWord.substring(vowel);
			pigWord = suffix + prefix + "ay";
		}

		return pigWord;

	}

}
