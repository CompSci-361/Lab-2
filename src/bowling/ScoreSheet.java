package bowling;

public class ScoreSheet {
	
	private Frame[] frames = new Frame[10];
	private int curIndex;
	
	public ScoreSheet() {
		curIndex=0;
	}
	public int getFrameScore(int frameNum) {
		Frame frame = getFrame(frameNum - 1);
		return frame.getScore();
	}
	public int getCurrentIndex() {
		return curIndex;
	}
	public int getCurrentFrame() {
		return curIndex + 1;
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
		if (frameNum > frames.length - 1) return null;
		return frames[frameNum];
	}
	public void throwBall(int pins) throws Exception {
		if (curIndex > 9) throw new Exception("Out of bounds.");
		if (pins > 10 || pins < 0) throw new Exception("Pin number is out of bounds.");
		
		Frame currentFrame = getFrame(getCurrentIndex());
		if (currentFrame == null) { //first throw, current frame = null
			if (pins == 10) {
				//strike. make a strike frame
				currentFrame = new StrikeFrame(this, curIndex);
				//update the frame in the array
				frames[curIndex] = currentFrame;
				curIndex++;
			}
			else {
				//make a regular frame for now.
				currentFrame = new Frame(this, curIndex);
				currentFrame.setThrowOne(pins);
				//update the frame in the array
				frames[curIndex] = currentFrame;
			}
		} else if (currentFrame.getThrowTwo() == -1) { //second throw
			//done with frame
			
			if (pins + currentFrame.getThrowOne() == 10) {
				//swap with a spare frame
				currentFrame = new SpareFrame(this, curIndex);
				//update the frame in the array
				frames[curIndex] = currentFrame;
			} else {
				currentFrame.setThrowTwo(pins);
			}
			curIndex++;
		}
	}
}
