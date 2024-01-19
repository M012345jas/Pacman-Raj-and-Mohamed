
public class ShellAnimation implements Animation {

	private static int universeCount = 0;
	private Universe current = null;
	private static int score = 0;
	
	
	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		ShellAnimation.score = score;
	}

	public static void addScore(int score) {
		ShellAnimation.score += score;
	}

	public int getLevel() {
		return universeCount;
	}
	
	public static void setUniverseCount(int count) {
		ShellAnimation.universeCount = count;
	}
	
	public Universe getNextUniverse() {

		universeCount++;
		
		if (universeCount == 1) {
			this.current = new PacUniverse();
		}
		else {
			this.current = null;
		}
		
		return this.current;

	}

	public Universe getCurrentUniverse() {
		return this.current;
	}
	public void restart() {
		universeCount = 0;
		current = null;		
	}
	
	public Universe restartUniverse(int universe) {
		
		if (universe == 1) {
			return new PacUniverse();
		}
		else {
		return null;
		}
}}
