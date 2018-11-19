package Ranking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RecordRanking {
	
	private Connection con;
	private PreparedStatement statement;

	public RecordRanking(int level, String name, int min, int sec, int score){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summative", "root", "");
			if(level==1)
				statement = con.prepareStatement("INSERT INTO level_1(Player,Minutes,Seconds,Score)VALUES(?,?,?,?)");
			else if(level==2)
				statement = con.prepareStatement("INSERT INTO level_2(Player,Minutes,Seconds,Score)VALUES(?,?,?,?)");
			statement.setString(1, name);
			statement.setInt(2, min);
			statement.setInt(3, sec);
			statement.setInt(4, score);
			statement.executeUpdate();
			statement.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
