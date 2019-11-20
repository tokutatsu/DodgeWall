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
		Connection connection = DriverManager.getConnection("jdbc:h2:./db/dodge_wall","sa","");
		Statement statement = connection.createStatement();
		statement.executeUpdate("create table if not exists ranking (id serial primary key, name text, score int)");
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery("select name, score from ranking order by score desc, id desc limit 10 offset 0");
		} catch ( SQLException e) {
			resultSet = statement.executeQuery("select name, score from ranking order by score desc, id desc");
		}
		ArrayList<HashMap<String, String>> recordList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> record;
		while ( resultSet.next() ) {
			record = new HashMap<String, String>();
			record.put("userName", resultSet.getString("name"));
			record.put("score", Integer.toString(resultSet.getInt("score")));
			recordList.add(record);
		}
		connection.close();
		return recordList;
	}

	public static void updateRanking(String userName, int score) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:h2:./db/dodge_wall", "sa", "");
		Statement statement = connection.createStatement();
		statement.executeUpdate("create table if not exists ranking (id serial primary key, name text, score int)");
		statement.executeUpdate("insert into ranking (name, score) values ('" + userName + "', " + score + ")");
		connection.close();
	}

}
