package process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Score {
	public static int getMyHighScore() throws Exception {
		try (
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DodgeWall",
						"postgres",
						"postgres");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"select max(score) from scores"
						);
				){
			int score = resultSet.getInt(0);
			return score;
		} catch ( SQLException e ) {
			return -1;
		}
	}

	public static boolean setMyHighScore(int score) throws Exception {
		try (
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DodgeWall",
						"postgres",
						"postgres");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"insert into scores (name, score) values ('Guest User', " + score + ")"
						);
				){
			return true;
		} catch ( SQLException e ) {
			return false;
		}
	}

}
