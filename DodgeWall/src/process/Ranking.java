package process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Ranking {
	public static ArrayList<HashMap<String, String>> getTopTenRanking() throws Exception { // 全ての記録の中でトップ10を返す
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dodge_wall","postgres","postgres");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select name, score from ranking order by score desc, id desc offset 0 limit 10");
		ArrayList<HashMap<String, String>> recordList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> record  = new HashMap<String, String>();
		while ( resultSet.next() ) {
			record.put("userName", resultSet.getString("name"));
			record.put("score", resultSet.getString("score"));
			recordList.add(record);
		}
		return recordList;
	}

	public static int getTopRanking() throws Exception { // すべての記録の中で一番高いスコアを返す
		try (
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dodge_wall",
						"postgres",
						"postgres");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"select max(score) from ranking"
						// "select name, score from ranking order by score desc, id desc limit 1" // 名前とセットで取るやつ
						);
				){
			int score = resultSet.getInt(0);
			return score;
		} catch ( SQLException e ) {
			return -1;
		}
	}

	public static void updateRanking(String userName, int score) throws Exception { // プレイ記録を記録する
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dodge_wall",
				"postgres",
				"postgres");
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert into ranking (name, score) values ('" + userName + "', " + score + ")");
	}

}
