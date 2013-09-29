package cs1;

/**
 * @author Griffin
 *
 * This class is my implementation of CS 210 Assignment 2
 * The task was to construct a space needle
 */
public class Assignment2 {
	
	private static int SIZE = 4;
	
	/** Draws a space needle */
	public static void run () {
		printShaft();
		printTopBase();
		printLowerHead();
		printShaft();
		printMidSection();
		printTopBase();
	}
	
	/** prints the base or top */
	private static void printTopBase () {
		for (int h= 0; h <= SIZE-1; h++) {
			String str = "__/";
				for (int w= 0; w< h; w++) str += ":::";
					str += "||";
				for (int w= 0; w< h; w++) str += ":::";
			printCentered(str + "\\__");
		}
		printConnector();
	}
	
	/** prints the line connecting the topbase and the lowerHead */
	private static void printConnector () {
		System.out.print('|');
		for (int i= 0; i< (SIZE*6); i++) {
			System.out.print("\"");
		}
		System.out.println('|');
	}
	
	/** prints the lower head */
	private static void printLowerHead () {
		for (int h= SIZE; h >0; h--) {
			String str = "\\_";
			for (int w= 0; w< (h*3)-1; w++) {
				str += "/\\";
			}
			printCentered(str + "_/");
		}
	}
	
	/** prints a shaft */
	private static void printShaft () {
		for (int i= 0; i< SIZE; i++) {
			printCentered("||");
		}
	}
	
	/** prints the mid-section */
	private static void printMidSection () {
		for (int i= 0; i< SIZE*SIZE; i++) {
			printCentered("|%%||%%|");
		}
	}
	
	/** Centers the given string and prints the line */
	private static void printCentered (String str) {
		int screenWidth = SIZE*6 +2;
		int offset = (screenWidth - str.length()) /2;
		for (int i= 0; i< offset; i++) System.out.print(" ");
		System.out.println(str);
	}
	
}
