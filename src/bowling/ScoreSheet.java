package bowling;

public class ScoreSheet {
	
	private Frame[] frames = new Frame[10];
	private int curFrame;
	
	public ScoreSheet() {
		curFrame=0;
		
		for(int i = 0; i < 10; i++) {
			frames[i] = new Frame(this, i);
		}
	}
	public int getFrameScore(int frameNum) {
		return getFrame(frameNum).getScore();
	}
	public int getCurrentFrame() {
		return curFrame;
	}
	public int getTotalScore() {
		int totalScore = 0;
		
		for(Frame frame : frames) {
			if (frame == null) continue;
			totalScore += frame.getScore();
		}
		
		return totalScore;
	}
	public Frame getFrame(int frameNum) {
		return frames[frameNum];
	}
	public void throwBall(int pins) throws Exception {
		if (curFrame > 9) throw new Exception("Out of bounds.");
		if (pins > 11 || pins < 0) throw new Exception("Pin number is out of bounds.");
		
		Frame currentFrame = getFrame(getCurrentFrame());
		if (currentFrame.getThrowOne() == -1) {
			currentFrame.setThrowOne(pins);
		} else if (currentFrame.getThrowTwo() == -1) {
			//done with frame
			currentFrame.setThrowTwo(pins);
			curFrame++;
		}
	}
}
