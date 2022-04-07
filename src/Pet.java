import java.io.Serializable;


public class Pet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date birthDate;
	
	public Pet() {
		setName("Furry");
		birthDate = new Date(1,1,2000);
	}
	
	/**
	 * A standard constructor.  If any value is set improperly, then
	 * default is used
	 * @param newName The name
	 * @param longHair Hair length
	 * @param newDate Birth date
	 */
	public Pet(String newName, Date newDate) {
		setName(newName);
		setBirthDate(newDate);
	}
	
	/**
	 * A copy constructor.
	 * @param other The pet to copy
	 */
	public Pet(Pet other) {
		if (other!=null) {
			name=other.name;
			birthDate = other.getBirthDate();
		}
	}

	
	/**
	 * Sets the name accordingly.  If param is null, does not do anything
	 * @param newName: The new name
	 */
	public void setName(String newName) {
		if (newName!=null)
			name = newName;
	}
	
	/**
	 * sets the birth date.  If null, then does nothing
	 * @param newDate The new date
	 */
	public void setBirthDate(Date newDate) {
		if (newDate!=null)
			birthDate = newDate;
	}

	/**
	 * Getter for a name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * The birth date of the cat
	 * @return The birth date
	 */
	public Date getBirthDate() {
		return new Date(birthDate);
	}
	
	@Override
	public String toString() {
		String result = "Pet, Name:" + name + ",";
		result += "birthdate: " + birthDate;
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
		Pet p = (Pet) other;
		return (p.name.equals(name)&&(p.birthDate.equals(birthDate)));
	}
	
}
