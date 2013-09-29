/** 	name: Griffin Howlett 	**\
\** 	date: 1/23/13			**/

import java.util.*;

public class ShoppingCart { //stores items a user has chosen
	public ShoppingCart() {
		orders = new ArrayList<ItemOrder>();
		isDiscounted = false;
	}
	
	public void add (ItemOrder order) {
		orders.set(itemIndex(order), order);
	}
	
	//replaces a previous order of the same item when it exists
	int itemIndex (ItemOrder order) {
		for (int i= 0; i< orders.size(); i++) {
			if (orders.get(i).getItem() == order.getItem()) {
				return i;
			}
		}
		orders.add(null); //allocates a new order position
		return orders.size() -1;   //and returns its index
	}
	
	public void setDiscount (boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}
	
	public double getTotal() {
		double total = 0;
		for (int i= 0; i< orders.size(); i++) 
			total += orders.get(i).getPrice();
		return (isDiscounted)? total *0.9 : total;
	}
	
	private ArrayList<ItemOrder> orders;
	private boolean isDiscounted;
}
