package bowling;

public class Frame {
	private int firstThrow = -1;
	private int secondThrow = -1;
	protected ScoreSheet parentSheet = null;
	protected int index = 0;
	
	public Frame(ScoreSheet parentScoreSheet, int index) {
		parentSheet = parentScoreSheet;
		this.index = index;
	}
	
	public int getScore() {
		return (firstThrow == -1 ? 0 : firstThrow) + (secondThrow == -1 ? 0 : secondThrow);
	}
	
	public int getThrowOne() {
		return firstThrow;
	}
	
	public int getThrowTwo() {
		return secondThrow;
	}
	
	public void setThrowOne(int value) {
		firstThrow = value;
	}
	
	public void setThrowTwo(int value) {
		secondThrow = value;
	}
}

