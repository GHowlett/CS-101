/**
 * 
 */
package assignment2;

import Critters.*;
import java.awt.*;

public class Lion extends Critter {

	public Action getMove(CritterInfo info) {
		if (colorAge++ >= 3) color = randColor();
		
		if (info.getFront() == Neighbor.OTHER) return Action.INFECT;
		else if (info.getFront() == Neighbor.WALL) return Action.LEFT;
		else if (info.getFront() == Neighbor.SAME) return Action.RIGHT;
		else return Action.HOP;
	}
	
	//returns color of critter
	public Color getColor() {return color;}
	//returns critter's text-identity
	public String toString() {return sprite;}
	
	private static Color randColor() {
		switch((int)Math.random()%3) {
		case(0): return Color.red;
		case(1): return Color.green;
		default: return Color.blue;
		}
	}
	
	private Color color = randColor(); 
	private final String sprite = "L";
	private int colorAge = 0;
}
