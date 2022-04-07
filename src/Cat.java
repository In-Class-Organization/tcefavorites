import java.io.Serializable;

//BRUH - change to add and re commit changes
//BRUH2 - second change in branch to recommit in branch

/**
 * A cat class
 *
 */
public class Cat extends Pet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isLongHair;
	
	public Cat() {
		setName("Feline");
		isLongHair = false;
		setBirthDate(new Date(1,1,2000));
	}
	
	/**
	 * A standard constructor.  If any value is set improperly, then
	 * default is used
	 * @param newName The name
	 * @param longHair Hair length
	 * @param newDate Birth date
	 */
	public Cat(String newName, boolean longHair, Date newDate) {
		setName(newName);
		setLongHair(longHair);
		setBirthDate(newDate);
	}
	
	/**
	 * A copy constructor.
	 * @param other The cat to copy
	 */
	public Cat(Cat other) {
		if (other!=null) {
			setName(other.getName());
			isLongHair = other.isLongHair;
			setBirthDate(other.getBirthDate());
		}
	}
	
	/**
	 * Sets the long hair attribute
	 * @param newLongHair The new value
	 */
	public void setLongHair(boolean newLongHair) {
		isLongHair = newLongHair;
	}
	
	/**
	 * Getter for hair length
	 * @return The hair length
	 */
	public boolean isLongHair() {
		return isLongHair;
	}
	
	@Override
	public String toString() {
		String result = "Cat, Name:" + getName() + ",";
		if (isLongHair) {
			result+="long-haired,";
		}
		else result+="short-haired,";
		result += "birthdate: " + getBirthDate();
		return result;
	}
	

	/**
	 * A standard equals method
	 * @param other The other cat
	 * @return true if they are the same
	 */
	public boolean equals(Object other) {
		if (other ==null)
			return false;
		if (other.getClass()!=getClass()) {
			return false;
		}
		Cat c = (Cat) other;
		return (super.equals(c))&&(c.isLongHair==isLongHair);
	}
	
}
