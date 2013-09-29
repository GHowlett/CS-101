/** 	name: Griffin Howlett 	**\
\** 	date: 1/23/13			**/

public class ItemOrder { //stores a particular item and quantity
	public ItemOrder (Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public double getPrice () {return item.priceFor(quantity);}
	public Item getItem () {return item;}
	
	private final Item item;
	private final int quantity;
}
