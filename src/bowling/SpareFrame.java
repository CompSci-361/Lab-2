package bowling;

public class SpareFrame extends Frame {
	public SpareFrame(ScoreSheet parentScoreSheet, int index) {
		super(parentScoreSheet, index);
	}

	@Override
	public int getScore() {
		//pretend nextFrame exists
		Frame nextFrame = parentSheet.getFrame(index + 1);
		if (nextFrame != null) {
			return 10 + nextFrame.getThrowOne();
		}
		return 10;
	}
}
