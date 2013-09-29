/** 	name: Griffin Howlett 	**\
\** 	date: 1/23/13			**/

/*
 			QUESTION ANSWERS:
	1.
		File read time = 0.62 seconds
		Process time = 6.0 milliseconds
		Total runtime = 0.626 seconds
		
		When the author says the program will "run faster" with sets,
		he likely means the process time, because that is the only "speedy"
		part of the program, which can be equated to running. Read time is
		more like dragging than running, and can't be optimized by code.
	2. 
		The read time is more than 99% of the total time
		
		this is to be expected because the transport of data from 
		the hard-drive to working memory is the slowest process there is.
	3.
		File read time=0.475 seconds
		Process time=6.0 milliseconds
		The read time is a little less than 99% of the total time
		
		This shows why optimization is evil (when premature).
		The real bottleneck lies in the file loading.
	4. 
		Nothing to explain here:
		Top 3 recurring letters in moby.txt:  [e=115002, t=86488, a=76442]
		Top 3 recurring letters in hamlet.txt:[e=17900, t=12098, o=11459]
*/

/**	This program compares the vocabulary of two
  	text files, reporting the number of words
  	in common and the percent of overlap		

	W.P. Iverson
	Bellevue College CS211
	Sample from text, Chapter 11
**/

import java.util.*;
import java.io.*;

public class Vocabulary3 {
    public static void main (String[] q) throws FileNotFoundException {
        
        Scanner input1 = new Scanner(new File("moby.txt"));
        Scanner input2 = new Scanner(new File("hamlet.txt"));

        double time1 = System.currentTimeMillis();
	        SortedSet<String> set1 = getWords(input1);
	        SortedSet<String> set2 = getWords(input2);
        double time2 = System.currentTimeMillis();
        System.out.println("File read time=" + (time2-time1)/1000 + " seconds");
        
        time1 = System.currentTimeMillis();
        	reportResults(set1, set2, getOverlap(set1, set2));
        time2 = System.currentTimeMillis();
        System.out.println("Process time=" + (time2-time1) + " milliseconds \n\n");
        
        //print out top 3 most common letters:
        Map<Character, Integer> mobyChars = getCounts(new FileInputStream("moby.txt"));
        System.out.println("Top 3 recurring letters in moby.txt:  " + 
        					topThree(sortValue(mobyChars))
        );
        Map<Character, Integer> hamletChars = getCounts(new FileInputStream("hamlet.txt"));
        System.out.println("Top 3 recurring letters in hamlet.txt:" + 
							topThree(sortValue(hamletChars))
        );
    }

    // get a map of words and number of occurrences
    public static Map<Character, Integer> getCounts (FileInputStream input) {
		Map<Character, Integer> charmap = new HashMap<Character, Integer>();
		Scanner file = new Scanner (input);
		file.useDelimiter("[^a-zA-Z]");
		
		for (String word= ""; file.hasNext(); word = file.next()) {
			for (char letter : word.toLowerCase().toCharArray()) {
				charmap.put(letter, (charmap.containsKey(letter)? 
									 charmap.get(letter)+1 : 1));
		}	}
		return charmap;
	}
	
	//sorts a map based on value rather than key
	private static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> sortValue (Map<K,V> map) 
	{	
		//sort map entries using a custom comparator that's based on values
	    SortedSet<Map.Entry<K,V>> entries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() { @Override 
	            public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	        		int comparison = e2.getValue().compareTo(e1.getValue());	 
	        		return (comparison != 0)? comparison : 1; 
            }	}
	    ); entries.addAll(map.entrySet()); 
	    return entries;
	}
	
	//slices sorted map entries down to the top 3 and puts them in a vector
	private static <K,V extends Comparable<? super V>>
	Vector<Map.Entry<K, V>> topThree (SortedSet<Map.Entry<K, V>> set) {
		Vector<Map.Entry<K, V>> result = new Vector<Map.Entry<K,V>>();
		for (Map.Entry<K, V> entry : set) {
			result.add(entry); 
			if (result.size() >= 3) return result;
		} return result; //result.size() <= 0
	}

    // post: reads all words from the given Scanner, turning them to lowercase
    //       and returning a sorted set of the vocabulary of the file
    public static SortedSet<String> getWords (Scanner input) {
    	
    	//limit input to alphabetic characters and apostrophes
    	input.useDelimiter("[^a-zA-Z']");
        
    	//return sorted, lowercase words
        SortedSet<String> words = new TreeSet<String>();
        while (input.hasNext()) {words.add(input.next().toLowerCase());}
        return words;
    }

    // pre : list1 and list2 are sorted and contain no duplicates
    // post: constructs and returns an ArrayList containing the words 
    //       in common betweeen list1 and list2
    public static SortedSet<String> getOverlap (SortedSet<String> list1,
                                               SortedSet<String> list2) {
        SortedSet<String> result = new TreeSet<String>();
        Iterator<String> i = list1.iterator(), j = list2.iterator();
        String iStr = i.next(), jStr = j.next();
        while (i.hasNext() && j.hasNext()) {
        	int comparison = iStr.compareTo(jStr);
            if (comparison == 0) {
                result.add(iStr);
                iStr = i.next();
                jStr = j.next();
            } else if (comparison < 0) {
                iStr = i.next();
            } else {// comparison > 0
            	jStr = j.next();
            }
        }
        return result;
    }

    // pre : overlap contains the words in common between list1 and list2
    // post: reports statistics about two word lists and their overlap
    public static void reportResults (SortedSet<String> set1,
                                      SortedSet<String> set2,
                                      SortedSet<String> overlap) {
        System.out.println("file #1 words = " + set1.size());
        System.out.println("file #2 words = " + set2.size());
        System.out.println("common words  = " + overlap.size());

        double percent1 = 100.0 * overlap.size() / set1.size();
        double percent2 = 100.0 * overlap.size() / set2.size();
        System.out.println("% of file 1 in overlap = " + percent1);
        System.out.println("% of file 2 in overlap = " + percent2);
    }
}
