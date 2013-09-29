package chapter1;

/**
 * My Implementation of Chapter 1, Project #3 
 * @author Griffin Howlett
 */
public class Project3 
{
	/** 
	 * Prints my variation of the nursury rhyme
	   "There Once Was a Lady Who Swallowed a Fly."
	 * Called by the chapter1 main() function */
	public static void run () 
	{
		printFlyVerse();
		printSpiderVerse();
		printBirdVerse();
		printCatVerse();
		printDogVerse();
		printCustomVerse();
		printHorseVerse();
	}
	
	/** Prints my custom addition to the last verse */
	private static void printCustomVerse () {
		System.out.println("One day this old lady woke up and she said,");
		System.out.println("\"I've swallowed so much, I wish I were dead.\"");
	} 
	/** Prints the last verse */
	private static void printHorseVerse () {
		System.out.println("There was an old lady who swallowed a horse,");
		System.out.println("She died of course.");
	} 
	/** Prints verse #5 */
	private static void printDogVerse () {
		System.out.println("There was an old lady who swallowed a dog,");
		System.out.println("What a hog to swallow a dog.");
		printDogReasoning();
	}
	/** Prints verse #4 */
	private static void printCatVerse () {
		System.out.println("There was an old lady who swallowed a cat,");
		System.out.println("Imagine that, to swallow a cat.");
		printCatReasoning();
	}
	/** Prints verse #3 */
	private static void printBirdVerse () {
		System.out.println("There was an old lady who swallowed a bird,");
		System.out.println("How absurb to swallow a bird.");
		printBirdReasoning();
	}
	/** Prints verse #2 */
	private static void printSpiderVerse () {
		System.out.println("There was an old lady who swallowed a spider,");
		System.out.println("That wriggled and iggled and jiggled inside her.");
		printSpiderReasoning();
	}
	/** Prints verse #1 */
	private static void printFlyVerse () {
		System.out.println("There was an old lady who swallowed a fly.");
		printFlyReasoning();
	}
	
	/** Prints the lady's reasoning behind swallowing the dog */
	private static void printDogReasoning () {
		System.out.println("She swalled the dog to catch the cat,");
		printCatReasoning();
	}
	/** Prints the lady's reasoning behind swallowing the cat */
	private static void printCatReasoning () {
		System.out.println("She swallowed the cat to catch the bird,");
		printBirdReasoning();
	}
	/** Prints the lady's reasoning behind swallowing the bird */
	private static void printBirdReasoning () {
		System.out.println("She swallowed the bird to catch the spider,");
		printSpiderReasoning();
	}
	/** Prints the lady's reasoning behind swallowing the spider
	 *  God knows why she didn't just swallow a frog -_-  */
	private static void printSpiderReasoning () {
		System.out.println("She swallowed the spider to catch the fly,");
		printFlyReasoning();
	}
	/** Prints the lady's reasoning behind swallowing the fly */
	private static void printFlyReasoning () {
		System.out.println("I don\'t know why she swallowed that fly,");
		System.out.println("Perhaps she\'ll die.\n");
	}

} //class Project3