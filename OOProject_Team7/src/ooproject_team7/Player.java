package ooproject;

/**
 * A class that represents a player 
 * object that inherits from Player. 
 */
public class Player extends Person 
{
	/**
	 * To create an instance of a player with their @param aFirstname @param aLastname
	 * @param aGender, @param age, @param aPhonenumber, @param aPosition
	 */
	public Player(String aFirstname, String aLastname, char aGender, int age, String aPhonenumber, String aPosition)
	{
		super(aFirstname, aLastname, aGender, age, aPhonenumber);
		this.positionPlayed = aPosition;
	}
	
	/**
	 * @return the player's position played
	 */
	public String getPosition() {
		return positionPlayed;
	}
	
	/**
	 * Set/Update the player's position played 
	 * with @param newPosition
	 */
	public void setPostion(String newPosition) {
		this.positionPlayed = newPosition; 
	}
	
	/**
	 * Instance variable
	 */
	private String positionPlayed;
}
