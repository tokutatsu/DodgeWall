package process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Score {
	public static int[] getTopTenScore() throws Exception { // 全ての記録の中でトップ10を返す
		try (
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DodgeWall",
						"postgres",
						"postgres");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"select score from scores order by score desc offset 0 limit 10"
						);
				){
			int[] score = new int[resultSet.getRow()];
			for ( int i = 0; i < resultSet.getRow(); i++ ) {
				score[i] = resultSet.getInt(i);
			}
			return score;
		} catch ( SQLException e ) {
			int[] score = {-1};
			return score;
		}
	}

	public static int getMyHighScore() throws Exception { //すべての記録の中で一番高いスコアを返す
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

	public static boolean setMyHighScore(int score) throws Exception { //名無しのプレイヤーのプレイ記録を記録する
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
