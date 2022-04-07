import java.io.Serializable;

/**
 * This represents a date.  It is meant for example purposes only.  Should
 * probably use java.util.Date instead.
 *
 */
public class Date implements Serializable {

	private int month = 1;
	private int date = 1;
	private int year = 2000;
	
	private Date() {
	}
	
	/**
	 * Creates a particular date.  Checks for sanity of date also.
	 * Anything that is invalid is set to a default
	 * @param newMonth The new month
	 * @param newDate The new date
	 * @param newYear The new year
	 */
	public Date(int newMonth, int newDate, int newYear) {
		setYear(newYear);
		setMonth(newMonth);
		setDate(newDate);
	}
	
	/**
	 * A copy constructor.  Creates a duplicate of other.
	 * @param other The other class to make a copy of
	 */
	public Date(Date other) {
		if (other!=null) {
			year = other.year;
			month = other.month;
			date = other.date;
		}
	}
	
	/**
	 * This sets the month if newMonth is between 1 and 12.  
	 * Does not change it otherwise
	 * @param newMonth The new month
	 */
	public void setMonth(int newMonth) {
		if ((newMonth>=1)&&(newMonth<=12)) {
			month = newMonth;
		}
	}
	
	/**
	 * This sets the data.  It checks for leap years and correctness of date
	 * by month.  An incorrect date makes no change
	 * @param newDate The new date
	 */
	public void setDate(int newDate) {
		if (newDate>=1) {
			if ((month==1)||(month==3)||(month==5)||(month==7)||
					(month==8)||(month==10)||(month==12)) {
				if (newDate<=31) 
					date = newDate;
			}
			else if (month==2) {
				if (newDate<=28) {
					date = newDate;
				}
				else if (newDate==29) {
					//Leap year rules, every 4 except every 100 except every 400
					if ((year%4==0)&&((year%100!=0)||(year%400==0))) {
						date = newDate;
					}
				}
			}
			else if (newDate<=30) {
				date = newDate;
			}
		}
	}
	
	/**
	 * This sets the year.  Does not allow negative years.
	 * @param newYear The new year.
	 */
	public void setYear(int newYear) {
		if (newYear>=0) {
			year = newYear;
		}
	}
	
	/**
	 * Returns the year
	 * @return The year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * returns the month
	 * @return The month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Returns the date
	 * @return The date
	 */
	public int getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return month + "/" + date + "/" + year;  
	}
	
	/**
	 * A standard equals method.  Determines if other is the same as this.
	 * @param other The other class to compare against
	 * @return true if they are the same
	 */
	public boolean equals(Object o) {
		if (o==null)
			return false;
		if (o.getClass()!=getClass()) {
			return false;
		}
		Date other = (Date) o;
		return ((year==other.year)&&(month==other.month)&&(date==other.date));
	}
}
