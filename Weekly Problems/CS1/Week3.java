package cs1;

/**
 *Refer to Programming projects problem 5 (page 129) from our class textbook - 
  this draws a rocket ship of a user specified size (the rocket ship figure in 
  the problem is of size 3).

 *Notice how the rocket can be structured into different parts (cone, middle section,  
  flame) and note that the cone and the flame are actually one and the same.

 *For this problem, you are to implement the coneFlame method which can be sized 
  from sizes 2 to 5 (use class class constant SIZE for storing this value). 
  Your main method should just have a call to: coneFlame()
 */
public class Week3 
{
	private static int SIZE = 3;
	
	public static void run () {
		coneFlame();
	}
	
	public static void coneFlame () {
		for (int i= 1; i<= SIZE; i++) {
			System.out.println(new String(new char[SIZE-i]).replace('\0', ' ') +
							   new String(new char[i]).replace('\0', '/') + "**" +
							   new String(new char[i]).replace('\0', '\\')
		    );
		}
	}
}
