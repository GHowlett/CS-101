package cs1;

public class Date {
	public Date(int year, int month, int day) {
		ymd = new int[] {year, month, day};
	}
	
	///data
	private int[] ymd; //values stored in array to allow for more concise coding 
	
	///getters
	public int getYear () {return ymd[0];}
	public int getMonth () {return ymd[1];}
	public int getDay () {return ymd[2];}
	
	public String getDayOfWeek () {
		final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		return days[new Date(1753, 1, 1).advanceTo(this) %7]; // Jan 1, 1753 was a Monday
	}
	
	public String toString () { //using getters produces cohesion
		return getYear() + "/" + getMonth() + "/" + getDay();
	}
	
	///methods
	public boolean isLeapYear () {
		return ((getYear()%4) == 0) && !((getYear()%100 == 0) && (getYear()%400 != 0));
	}
	
	public void nextDay () {
		if (ymd[2] == daysInMonth(ymd[1])) {
			if (ymd[1] == 12) {
				ymd[0]++;
				ymd[1] = 0; //incremented to 1 later
				
			}
			ymd[1]++;
			ymd[2] = 0; //incremented to 1 later
		}
		ymd[2]++;
	}
	
	//note that although polling equals() increases cohesion, it hinders performance
	public int advanceTo (Date endDay) {
		int dayCount = 0;
		while (!equals(endDay)) {
			nextDay(); dayCount++;
		} 
		return dayCount;
	} 
	
	private int daysInMonth (int month) { //note that this function is affected by year
		if (month==4 || month==6 || month==9 || month==11) 	return 30;
		else if (month==2) 									return isLeapYear()? 29: 28;
		else 												return 31;
	}
	
	public boolean equals (Date d) {
		int[] ymd2 = new int[] {d.getYear(), d.getMonth(), d.getDay()};
		for (int i= 0; i< 3; i++) if (ymd[i] != ymd2[i]) return false;
		return true;
	}
	
	
}