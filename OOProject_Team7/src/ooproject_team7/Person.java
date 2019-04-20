package ooproject;

/**
 * A class that represents a person 
 * object. 
 */
public class Person 
{
	/**
	 * To create an instance of a person with their @param aFirstname @param aLastname
	 * @param aGender, @param age and @param aPhonenumber
	 */
	public Person(String aFirstname, String aLastname, char aGender, int age, String aPhonenumber) 
	{
		this.firstName = aFirstname;
		this.lastName = aLastname;
		this.gender = aGender;
		this.age = age;
		this.phoneNumber = aPhonenumber;
	}
	
	/**
	 * @return the person's first name 
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return the person's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @return the person's gender
	 */
	public char getGender() {
		return gender;
	}
	
	/**
	 * @return the person's age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @return the person's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Set/Update the person's first name 
	 * with @param firstname
	 */
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	
	/**
	 * Set/Update the person's last name 
	 * with @param lastname
	 */
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	
	/**
	 * Set/Update the person's gender 
	 * with @param gender
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	/**
	 * Set/Update the person's age 
	 * with @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Set/Update the person's phone number 
	 * with @param phonenumber
	 */
	public void setPhoneNumber(String phonenumber) {
		this.phoneNumber = phonenumber;
	}
	
	/**
	 * Instance variables
	 */
	private String firstName, lastName;
	private char gender;
	private int age;
	private String phoneNumber;
}
