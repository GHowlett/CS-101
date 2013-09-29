/** name: Griffin Howlett 							   **\
|** date: 1/10/13		  							   **|
|** comments: I used the Double class rather than the  **|
\** 		  primitive type so I could set it to null **/

package assignment1;
import java.awt.Point;
import java.lang.Double;

public class Line { // as in a linear equation 
	
	public Line (Point p1, Point p2) {
		slope = (p2.x != p1.x) ? (double)(p2.y-p1.y)/(p2.x-p1.x) : null;
		intercept = (slope != null) ? p1.y - (p1.x * slope) : p1.x; 
	}   // if the intercept is null, then the line is vertical (x = #)
	
	public boolean intersect(Line other) {
		return (this.slope == other.slope)? false : true;
	}	// all linear equations intersect unless parallel
	
	public double getSlope () {return slope;}
	
	public String toString() {
		if (slope == null) return "x = " + intercept;
		else return ("y = ") + 
					((slope != 0)? slope.doubleValue()+"x + " : "") + 
					(intercept.doubleValue())
		; //TODO: restructure this using multi-input switch eg: switch(m, b)
	}	
	
	private java.lang.Double slope, intercept;
}
