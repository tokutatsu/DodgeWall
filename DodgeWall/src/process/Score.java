package process;

public class Score {

	private static int score;

	public static void init() {
		score = 0;
	}

	public static void count() {
		score += 1;
	}

	public static int getScore() {
		return score;
	}

}
