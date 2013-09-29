package cs1;

import java.util.Scanner;
import cs1.Date;

public class DataClient {
	
	public static void run () {
		Scanner console = new Scanner(System.in);
		
		while (true) {
			System.out.print("What is today's date (month day year)? ");
			int[] mdy1 = new int[] {console.nextInt(), console.nextInt(), console.nextInt()};
			
			System.out.print("What is your birthday (month day year)? ");
			int[] mdy2 = new int[] {console.nextInt(), console.nextInt(), console.nextInt()};
			
			Date today = new Date(mdy1[2], mdy1[0], mdy1[1]),
				 birth = new Date(mdy2[2], mdy2[0], mdy2[1]);
			
			System.out.printf("You were born on %s, which was a %s.\n", birth.toString(), birth.getDayOfWeek());
			if (birth.isLeapYear()) System.out.printf("%d was a leap year.\n", birth.getYear());
			System.out.printf("You are %d days old.\n\n\n", birth.advanceTo(today));
		}
	}
	
}
