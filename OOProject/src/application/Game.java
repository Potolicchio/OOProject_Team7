package application;

public class Game {
	
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
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	
	public String getField()
	{
		return field;
	}
	
	public void setField(String field)
	{
		this.field = field;
	}
	
	public String getHomeTeam()
	{
		return homeTeam;
	}
	
	public void setHomeTeam(String homeTeam)
	{
		this.homeTeam = homeTeam;
	}
	
	public int getHomeGoals()
	{
		return homeGoals;
	}
	
	public void setHomeGoals(int homeGoals)
	{
		this.homeGoals = homeGoals;
	}
	
	public String getAwayTeam()
	{
		return awayTeam;
	}
	
	public void setAwayTeam(String awayTeam)
	{
		this.awayTeam = awayTeam;
	}
	
	public int getAwayGoals()
	{
		return awayGoals;
	}
	
	public void setAwayGoals(int awayGoals)
	{
		this.awayGoals = awayGoals;
	}
	
	public String getWinner()
	{
		return winner;
	}
	
	public void setWinner(String winner)
	{
		this.winner = winner;
	}
	
	// Additional Methods
	
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
