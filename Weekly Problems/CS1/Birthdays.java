package cs1;

import java.util.*;

public class Birthdays {
	
	private static int currentMonth= 1, currentDay= 1;
	
	public static void run () {
		printPurpose();
		printToday();
		
		String bday1, bday2;
		printFacts(bday1 = getBirthDate("Person 1"));
		printFacts(bday2 = getBirthDate("Person 2"));
		
		printComparison(bday1, bday2);
		
		printMyFact();
	}
	
	private static void printPurpose () {
		System.out.print("This program compares two birthdays \n");
		System.out.print("and displays which one is sooner. \n");
	}
	private static void printToday () {
		System.out.printf("Today is %s, ", formatDate(currentMonth, currentDay, 2012));
		System.out.printf("day #%d of the year. \n\n", absDay(currentMonth, currentDay));
	}
	
	//each char of the string encodes an int
	private static String getBirthDate (String person) {
		Scanner console = new Scanner(System.in);
		System.out.print(person + ":\n" + "What month and day were you born? ");
		return new String() + (char)console.nextInt() + (char)console.nextInt();
	}

	private static void printFacts (String birthdate) {
		//each char of the string encodes an int
		int month = (int)birthdate.charAt(0);
		int day = (int)birthdate.charAt(1);
		int year = computeYear(month, day);
		
		printFallDate(month, day, year);
		printBirthDistance(month, day);
	}
	
	private static int computeYear (int month, int day) {
		if (month<currentMonth || (month==currentMonth && day<currentDay)) {
			return 2013;
		}
		else return 2012;
	}
	
	private static void printFallDate (int month, int day, int year) {
		System.out.printf("%s falls on day #%d of 366. \n", formatDate(day, month, year), absDay(month, day));
	}
	
	private static void printBirthDistance (int month, int day) {
		int diff = computeDiff(month, day);
		if (diff != 0) {
			System.out.printf("Your next birthday is in %d day(s). \n", diff);
			System.out.printf("That is %.1f percent of a year away. \n\n", 100*(float)diff/366);
		}
		else System.out.println("Happy birthday! \n");
	}
	
	private static int computeDiff (int month, int day) {
		int diff = absDay(month, day) - absDay(currentMonth, currentDay);
		if (diff < 0) {diff += 366;}
		return diff;
	}
	
	private static String formatDate (int month, int day, int year) {
		return day + "/" + month + "/" + year; 
	}
	
	private static int absDay (int month, int day) {
		for (month--; month >0; month--) {
			if (month==4 || month==6 || month==9 || month==11) 	day += 30;
			else if (month==2) 									day += 29;
			else 												day += 31;
		} 
		return day;
	}
	
	private static void printComparison (String date1, String date2) {
		int diff1 = computeDiff(date1.charAt(0), date1.charAt(1));
		int diff2 = computeDiff(date2.charAt(0), date2.charAt(1));
		
		if 		(diff1 < diff2) System.out.println("Person 1's birthday is sooner. \n");
		else if (diff1 > diff2) System.out.println("Person 2's birhtday is sooner. \n");
		else 	System.out.println("Wow, you share the same birthday! \n");
	}
	
	private static void printMyFact () {
		System.out.println("On my birthday, 12/29, Hong Kong began slaughtering \n" +
						   "all its chickens in order to prevent bird flu! ^_^")
		;
	}
}
