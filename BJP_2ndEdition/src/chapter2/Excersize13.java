package chapter2;
import java.util.*;

public class Excersize13 {
	public static void run () {	
		Scanner reader = new Scanner(System.in);
		while (true) {
			printPalindrome(reader);
			if (getInput("Again? (yes/no)", reader).equalsIgnoreCase("no")) break;
			System.out.println("------------------------------------\n");
		}
	}
	
	private static void printPalindrome (Scanner reader) {
		printIsPalindrome( getInput("Please enter a string to examine", reader) );
	}
	
	private static String getInput (String request, Scanner reader) {
		System.out.print(request + ": ");  
		return reader.nextLine();
	}
	
	private static void printIsPalindrome(String str) {
		System.out.println(	str + 
	    					((str.equalsIgnoreCase(reverse(str.toCharArray())))? " == " : " =\\= ") +
	    					reverse(str.toCharArray()) + "\n"
		);
	}
	
	private static String reverse (char[] str) {
		for (int i= 1; i <= (str.length/2); i++) {
			char temp = str[i -1];
			str[i -1] = str[str.length -i];
			str[str.length -i] = temp;
		}
		return new String(str);
	}
}
