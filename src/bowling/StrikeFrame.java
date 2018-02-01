package bowling;


public class StrikeFrame extends Frame {
	public StrikeFrame(ScoreSheet parentScoreSheet, int index) {
		super(parentScoreSheet, index);
	}

	@Override
	public int getScore() {
		//pretend nextFrame exists
		Frame nextFrame = parentSheet.getFrame(index + 1);
		if (nextFrame != null) {
			return 10 + nextFrame.getScore();
		}
		return 10;
	}
	
	@Override
	public int getThrowOne() {
		return 10;
	}
	
	@Override
	public int getThrowTwo() {
		return 0;
	}
}