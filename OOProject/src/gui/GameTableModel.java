package gui;

import application.Game;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel
{
	public GameTableModel (List<Game> theGames)
	{
		games = theGames;
	}
	
	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}
	
	@Override
	public int getRowCount()
	{
		return games.size();
	}
	
	@Override
	public String getColumnName(int col)
	{
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col)
	{
		Game tempGame = games.get(row);
		
		switch(col)
		{
		case DATE_COL:
			return tempGame.getDate();
		case TIME_COL:
			return tempGame.getTime();
		case FIELD_COL:
			return tempGame.getField();
		case HOME_TEAM_COL:
			return tempGame.getHomeTeam();
		case HOME_GOALS_COL:
			return tempGame.getHomeGoals();
		case AWAY_TEAM_COL:
			return tempGame.getAwayTeam();
		case AWAY_GOALS_COL:
			return tempGame.getAwayGoals();	
		case WINNER_COL:
			return tempGame.getWinner();
		default:	
			return tempGame.getDate();
		}
	}
	
	@Override
	public Class getColumnClass(int c)
	{
		return getValueAt(0, c).getClass();
	}
	
	private static final int DATE_COL = 0;
	private static final int TIME_COL = 1;
	private static final int FIELD_COL = 2;
	private static final int HOME_TEAM_COL = 3;
	private static final int HOME_GOALS_COL = 4;
	private static final int AWAY_TEAM_COL = 5;
	private static final int AWAY_GOALS_COL = 6;
	private static final int WINNER_COL = 7;
	
	private String[] columnNames = 
		{
				"Date",
				"Time",
				"Field",
				"Home Team",
				"Home Goals",
				"Away Team",
				"Away Goals",
				"Winner"
		};
	
	private List<Game> games;
}
