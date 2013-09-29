package cs1;
import java.io.*;

/**
 * Change Maker: Write a program that takes an input integer N (number of pennies) 
 * and prints out the best way (fewest number of coins) to make change using US 
 * coins (quarters, dimes, nickels, and pennies only). For example, if N = 67 
 * then it prints out: 2 quarters, 1 dime, 1 nickel and 2 pennies.
 */
public class Week2 
{	
	//accepts a user's pennies and outputs the optimal change 
	public static void run () throws IOException 
	{	
		DataInput in = new DataInputStream(System.in);
		int pennyCount; //will never be more than a dollar
		
		while(true) {
			System.out.print("Number of Pennies: ");
			
			pennyCount = Integer.parseInt(in.readLine());
			if (pennyCount >= 0) break; 
			
			System.out.print("Incorrect input, please try again...\n\n");
		}
		makeChange(pennyCount);
	}

	//prints the optimal change for any penny count
	private static void makeChange (int pennyCount)
	{
		int quarterCount = pennyCount/25;
		pennyCount -= quarterCount*25;
		
		int dimeCount = pennyCount/10;
		pennyCount -= dimeCount*10;
		
		int nickelCount = pennyCount/5;
		pennyCount -= nickelCount*5;
		
		printChange(quarterCount, dimeCount, nickelCount, pennyCount);
	}
	
	//prints the change to the console
	private static void printChange (int Q,int D, int N, int P)
	{
		//TODO: find out why (char)' ' doesn't behave the same as (single-char string)" "
		System.out.print("Change ="); 
		System.out.print(" " + Q + " quarter" + (Q != 1? 's' : "") + ',');
		System.out.print(" " + D + " dime" + (D != 1? 's' : "") + ',');
		System.out.print(" " + N + " nickel" + (N != 1? 's' : "") + " and");
		System.out.print(" " + P + (P != 1? " pennies" : " penny"));
	}
	
} //class ChangeDispenser
