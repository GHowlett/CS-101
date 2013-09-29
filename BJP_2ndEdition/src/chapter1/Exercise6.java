package chapter1;

/**
 * My Implementation of Chapter 1, Exercise #6
 * @author Griffin Howlett 
 */
public class Exercise6 {

	/** 
	 * Prints the statement listed under exercise 6,
	 * called by the chapter1 main() function */
	public static void run () {
		printUntrueStatement();
		System.out.println("");
		printUntrueStatement();
	}

	/** 
	 * Prints what every coder must understand
	 * @name: there's definitely more than 1 thing every coder must understand ;) */
	private static void printUntrueStatement () {
		System.out.println("There\'s one thing every coder must understand:");
		System.out.println("The System.out.println command.");
	}
	
} //class Exercise6
