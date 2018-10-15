package week1Capstonepackage;

import java.util.Scanner;

public class PigLatinTranslator {

	public static String translator(String oldWord) {

		oldWord = oldWord.toLowerCase();
		String pigWord = oldWord;
		// If a vowel exists at index 0:
		if (oldWord.indexOf('a') == 0 || oldWord.indexOf('e') == 0 || oldWord.indexOf('i') == 0
				|| oldWord.indexOf('o') == 0 || oldWord.indexOf('u') == 0) {
			pigWord = oldWord + "way";
		}
		// If the first index of a vowel is at 1:
		else if (oldWord.indexOf('a') == 1 || oldWord.indexOf('e') == 1 || oldWord.indexOf('i') == 1
				|| oldWord.indexOf('o') == 1 || oldWord.indexOf('u') == 1) {
			pigWord = oldWord.substring(1) + oldWord.charAt(0) + "ay";
		}
		// If the first index of a vowel is at 2:
		else if (oldWord.indexOf('a') == 2 || oldWord.indexOf('e') == 2 || oldWord.indexOf('i') == 2
				|| oldWord.indexOf('o') == 2 || oldWord.indexOf('u') == 2) {
			pigWord = oldWord.substring(2) + oldWord.substring(0, 2) + "ay";
		}
		// If the first index of a vowel is at 3:
		else if (oldWord.indexOf('a') == 3 || oldWord.indexOf('e') == 3 || oldWord.indexOf('i') == 3
				|| oldWord.indexOf('o') == 3 || oldWord.indexOf('u') == 3) {
			pigWord = oldWord.substring(3) + oldWord.substring(0, 3) + "ay";
		}
		return pigWord;

	}

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

}
