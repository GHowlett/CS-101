/** 	name: Griffin Howlett 	**\
\** 	date: 1/23/13			**/

import java.util.*;

public class Catalog { //stores every item available 
	public Catalog (String name) {
		this.name = name;
		this.items = new ArrayList<Item>();
	}
	
	public void add(Item item) {items.add(item);}
	public int size() {return items.size();}
	public Item get(int index) {return items.get(index);}
	public String getName() {return name;}

	private final String name;
	private ArrayList<Item> items;
}
