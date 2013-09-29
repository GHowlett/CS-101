package cs1;

import java.util.*;

public class Week6and7 {
	public static void run () {
		Random rand = new Random();
		int headCount = 0;
		
		while (headCount < 3) {
			if (rand.nextBoolean()) {
				headCount++;
				System.out.print("H ");
			} 
			else {
				headCount = 0;
				System.out.print("T ");
			}
		}
		
		System.out.print("\n Three heads in a row!");
	}
}
