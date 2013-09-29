import assignment1.Line;
import java.awt.Point;

public class main {
	public static void main(String[] args) {
		Line line1 = new Line(new Point(5, 3), new Point(0,0));
		Line line2 = line1;
		
		System.out.print(line1.toString());
	}

}
