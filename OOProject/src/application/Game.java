package application;

public class Game {
	
	/**
	 * Constructor for the Game objects.
	 * @param date String variable that holds a date in format "mm/dd/yyyy"
	 * @param time String variable that holds a time in format "xx:xx am/pm"
	 * @param field String variable that holds the name of a location.
	 * @param homeTeam String variable that holds the name of the home team.
	 * @param homeGoals Integer variable that holds the amount of goals the home team made/makes in the game.
	 * @param awayTeam String variable that holds the name of the away team.
	 * @param awayGoals Integer variable that holds the amount of goals the away team made/makes in the game.
	 * @param winner String variable that holds the name of the winning team for that game.
	 */
	public Game(String date, String time, String field, String homeTeam, int homeGoals, String awayTeam, int awayGoals, String winner)
	{
		this.date = date;
		this.time = time;
		this.field = field;
		this.homeTeam = homeTeam;
		this.homeGoals = homeGoals;
		this.awayTeam = awayTeam;
		this.awayGoals = awayGoals;
		this.winner = winner;
	}
	
	// Getters and Setters
	
	/**
	 * Getter for the date of a Game
	 * @return date String variable that holds a date in format "mm/dd/yyyy"
	 */
	public String getDate()
	{
		return date;
	}
	
	/**
	 * Setter for the date of a Game
	 * @param date String variable that holds a date in format "mm/dd/yyyy"
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	
	/**
	 * Getter for the time of a Game
	 * @return time String variable that holds a time in format "xx:xx am/pm"
	 */
	public String getTime()
	{
		return time;
	}
	
	/**
	 * Setter for the time of a Game
	 * @param time String variable that holds a time in format "xx:xx am/pm"
	 */
	public void setTime(String time)
	{
		this.time = time;
	}
	
	/**
	 * Getter for the field of a Game
	 * @return field String variable that holds the name of a location.
	 */
	public String getField()
	{
		return field;
	}
	
	/**
	 * Setter for the field of a Game
	 * @param field String variable that holds the name of a location.
	 */
	public void setField(String field)
	{
		this.field = field;
	}
	
	/**
	 * Getter for the name of the home team in a Game
	 * @return homeTeam String variable that holds the name of the home team.
	 */
	public String getHomeTeam()
	{
		return homeTeam;
	}
	
	/**
	 * Setter for the name of the home team in a Game
	 * @param homeTeam String variable that holds the name of the home team.
	 */
	public void setHomeTeam(String homeTeam)
	{
		this.homeTeam = homeTeam;
	}
	
	/**
	 * Getter for the number of goals the home team made/makes in a Game
	 * @return homeGoals Integer variable that holds the amount of goals the home team made/makes in the game.
	 */
	public int getHomeGoals()
	{
		return homeGoals;
	}
	
	/**
	 * Setter for the number of goals the home team made/makes in a Game
	 * @param homeGoals Integer variable that holds the amount of goals the home team made/makes in the game.
	 */
	public void setHomeGoals(int homeGoals)
	{
		this.homeGoals = homeGoals;
	}
	
	/**
	 * Getter for the name of the away team in a Game
	 * @return awayTeam String variable that holds the name of the away team.
	 */
	public String getAwayTeam()
	{
		return awayTeam;
	}
	
	/**
	 * Setter for the name of the away team in a Game
	 * @param awayTeam String variable that holds the name of the away team.
	 */
	public void setAwayTeam(String awayTeam)
	{
		this.awayTeam = awayTeam;
	}
	
	/**
	 * Getter for the number of goals the away team made/makes in a Game
	 * @return awayGoals Integer variable that holds the amount of goals the away team made/makes in the game.
	 */
	public int getAwayGoals()
	{
		return awayGoals;
	}
	
	/**
	 * Setter for the number of goals the away team made/makes in a Game
	 * @param awayGoals Integer variable that holds the amount of goals the away team made/makes in the game.
	 */
	public void setAwayGoals(int awayGoals)
	{
		this.awayGoals = awayGoals;
	}
	
	/**
	 * Getter for the name of the winning team in a Game
	 * @return winner String variable that holds the name of the winning team for that game.
	 */
	public String getWinner()
	{
		return winner;
	}
	
	/**
	 * Setter for the name of the winning team in a Game
	 * @param winner String variable that holds the name of the winning team for that game.
	 */
	public void setWinner(String winner)
	{
		this.winner = winner;
	}
	
	// Additional Methods
	// Functionality not implemented
	
	/*public Referee getReferee()
	{
		
	}
	
	public String publishResult()
	{
		
	}*/
	
	private String date;
	private String time;
	private String field;
	private String homeTeam;
	private int homeGoals;
	private String awayTeam;
	private int awayGoals;
	private String winner;
}
