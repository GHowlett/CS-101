/** 	name: Griffin Howlett 	**\
\** 	date: 1/23/13			**/

public class Item { //stores pricing information for a particular item
	public Item (String name, double price) {
		this(name, price, 1, price); //price doesn't change with higher quantity
	}

	public Item (String name, double price, int bulQuantity, double bulPrice) {
		validatePos((int)price & (int)bulPrice & bulQuantity);
		this.name = name;
		this.regPrice = price;
		this.bulPrice = bulPrice;
		this.bulQuantity = bulQuantity;
	}
	
	public double priceFor (int quantity) {
		validatePos(quantity);
		if (quantity >= bulQuantity) {
			return (double)(quantity -bulQuantity)*regPrice + bulPrice; 
		}
		else return (double)quantity*regPrice;
	}
	
	public String toString () { //string formatting for the US dollar 
		return name + String.format(", $%04.2f", regPrice) + (
			(regPrice != bulPrice)? String.format(" (%d for $%04.2f)", bulQuantity, bulPrice): ""
		);
	}
	
	//no numbers in this program should every be negative
	private static void validatePos (double numb) {
		if (numb< 0) throw new IllegalArgumentException("Prices cannot be negative");
	}
	
	private final int bulQuantity; 
	private final double regPrice, bulPrice;
	private final String name; 
}
