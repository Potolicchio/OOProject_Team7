package application;

import java.util.ArrayList;

public class Team {
	
	public Team(int division, String name, int standing, int wins, int losses, int ties, int points)
	{
		this.division = division;
		this.name = name;
		this.standing = standing;
		this.wins = wins;
		this.losses = wins;
		this.ties = ties;
		this.points = points;
	}
	
	// Getters and Setters
	
	public int getDivision()
	{
		return division;
	}
	
	public void setDivision(int division)
	{
		this.division = division;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getStanding()
	{
		return standing;
	}
	
	public void setStanding(int standing)
	{
		this.standing = standing;
	}
	
	public int getWins()
	{
		return wins;
	}
	
	public void setWins(int wins)
	{
		this.wins = wins;
	}
	
	public int getLosses()
	{
		return losses;
	}
	
	public void setLosses(int losses)
	{
		this.losses = losses;
	}
	
	public int getTies()
	{
		return ties;
	}
	
	public void setTies(int ties)
	{
		this.ties = ties;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public void setPoints(int points)
	{
		this.points = points;
	}
	
	// Additional Methods
	
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
	
	private int division;
	private String name;
	private int standing;
	private int wins;
	private int losses;
	private int ties;
	private int points;
	//private ArrayList<Player> Player;
}
