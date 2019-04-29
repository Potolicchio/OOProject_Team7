package application;

public class Team {
	
	/**
	 * Constructor for the Team objects.
	 * @param name String variable that holds the name of the Team.
	 * @param division Integer variable that holds the division of the Team.
	 * @param standing Integer variable that holds the standing of the Team.
	 * @param wins Integer variable that holds the number of wins the Team has.
	 * @param losses Integer variable that holds the number of losses the Team has.
	 * @param ties Integer variable that holds the number of ties the Team has.
	 * @param points Integer variable that holds the number of points the Team has based on Wins, Losses, and Ties.
	 */
	public Team(String name, int division, int standing, int wins, int losses, int ties, int points)
	{
		this.name = name;
		this.division = division;
		this.standing = standing;
		this.wins = wins;
		this.losses = wins;
		this.ties = ties;
		this.points = points;
	}
	
	// Getters and Setters
	
	/**
	 * Getter for the name of the Team
	 * @return name String variable that holds the name of the Team.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Setter for the name of the Team
	 * @param name String variable that holds the name of the Team.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Getter for the division of the Team
	 * @return division Integer variable that holds the division of the Team.
	 */
	public int getDivision()
	{
		return division;
	}
	
	/**
	 * Setter for the division of the Team
	 * @param division Integer variable that holds the division of the Team.
	 */
	public void setDivision(int division)
	{
		this.division = division;
	}
	
	/**
	 * Getter for the standing of the Team
	 * @return standing Integer variable that holds the standing of the Team.
	 */
	public int getStanding()
	{
		return standing;
	}
	
	/**
	 * Setter for the standing of the team
	 * @param standing Integer variable that holds the standing of the Team.
	 */
	public void setStanding(int standing)
	{
		this.standing = standing;
	}
	
	/**
	 * Getter for the number of wins a Team has
	 * @return wins Integer variable that holds the number of wins the Team has.
	 */
	public int getWins()
	{
		return wins;
	}
	
	/**
	 * Setter for the number of wins a Team has
	 * @param wins Integer variable that holds the number of wins the Team has.
	 */
	public void setWins(int wins)
	{
		this.wins = wins;
	}
	
	/**
	 * Getter for the number of losses a Team has
	 * @return losses Integer variable that holds the number of losses the Team has.
	 */
	public int getLosses()
	{
		return losses;
	}
	
	/**
	 * Setter for the number of losses a Team has
	 * @param losses Integer variable that holds the number of losses the Team has.
	 */
	public void setLosses(int losses)
	{
		this.losses = losses;
	}
	
	/**
	 * Getter for the number of ties a Team has
	 * @return ties Integer variable that holds the number of ties the Team has.
	 */
	public int getTies()
	{
		return ties;
	}
	
	/**
	 * Setter for the number of ties a Team has
	 * @param ties Integer variable that holds the number of ties the Team has.
	 */
	public void setTies(int ties)
	{
		this.ties = ties;
	}
	
	/**
	 * Getter for the number of points a Team has
	 * @return points Integer variable that holds the number of points the Team has based on Wins, Losses, and Ties.
	 */
	public int getPoints()
	{
		return points;
	}
	
	/**
	 * Setter for the number of points a Team has
	 * @param points Integer variable that holds the number of points the Team has based on Wins, Losses, and Ties.
	 */
	public void setPoints(int points)
	{
		this.points = points;
	}
	
	// Additional Methods
	// Functionality not implemented
	
	public void addPlayer() 
	{
		
	}
	
	public void removePlayer()
	{
		
	}
	
	public int calculatePoints()
	{
		return points;
	}
	
	private String name;
	private int division;
	private int standing;
	private int wins;
	private int losses;
	private int ties;
	private int points;
	//private ArrayList<Player> Player;
}
