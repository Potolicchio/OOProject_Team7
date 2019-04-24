package gui;

import application.Team;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TeamTableModel extends AbstractTableModel 
{
	public TeamTableModel (List<Team> theTeams)
	{
		teams = theTeams;
	}
	
	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}
	
	@Override
	public int getRowCount()
	{
		return teams.size();
	}
	
	@Override
	public String getColumnName(int col)
	{
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col)
	{
		Team tempTeam = teams.get(row);
		
		switch(col)
		{
		case TEAM_NAME_COL:
			return tempTeam.getName();
		case DIVISION_COL:
			return tempTeam.getDivision();
		case STANDING_COL:
			return tempTeam.getStanding();
		case WINS_COL:
			return tempTeam.getWins();
		case LOSSES_COL:
			return tempTeam.getLosses();
		case TIES_COL:
			return tempTeam.getTies();
		case POINTS_COL:
			return tempTeam.getPoints();	
		default:	
			return tempTeam.getName();
		}
	}
	
	@Override
	public Class getColumnClass(int c)
	{
		return getValueAt(0, c).getClass();
	}
	
	private static final int TEAM_NAME_COL = 0;
	private static final int DIVISION_COL = 1;
	private static final int STANDING_COL = 2;
	private static final int WINS_COL = 3;
	private static final int LOSSES_COL = 4;
	private static final int TIES_COL = 5;
	private static final int POINTS_COL = 6;
	
	private String[] columnNames = 
		{
				"Team",
				"Division",
				"Standing",
				"Wins",
				"Losses",
				"Ties",
				"Points"
		};
	
	private List<Team> teams;
}
