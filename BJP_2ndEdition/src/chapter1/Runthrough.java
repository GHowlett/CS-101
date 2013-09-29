package chapter1;

public class Runthrough {

	/** Runs all the exercises and projects assigned in chapter 1 */
	public static void main(String[] args) 
	{
//		System.out.println("Exercise 5 \n---------------------------------------------- \n");
//		Exercise5.run();
//		System.out.println("\n\n");
//		
//		System.out.println("Exercise 6 \n---------------------------------------------- \n");
//		Exercise6.run();
//		System.out.println("\n\n");
//		
//		System.out.println("Project 3 \n---------------------------------------------- \n");
//		Project3.run();
//		System.out.println("\n\n");
		
		
	}
	
	private int testAccumulator (int n) {
		for ( 	int month= n -1, totalDays= 0;;
				month--, totalDays += ((month*month)%9)/2
			){	if (month == 1) return totalDays;    
	    }
		
		
	}
}
