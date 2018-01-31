package bowling;

public class ScoreSheet {
	
	private Frame[] frames = new Frame[10];
	private int totalScore;
	private int curFrame;
	
	public ScoreSheet() {
		totalScore=0;
		curFrame=0;
		
	}
	public int getFrameScore(int frameNum) {
		if(frames[frameNum-1].getStatus()==FrameStatus.Strike) {
			frames[frameNum-1].setScore(frames[frameNum], frames[frameNum+1]);
		}else if(frames[frameNum-1].getStatus()==FrameStatus.Spare) {
			frames[frameNum-1].setScore(frames[frameNum]);
		}
		return frames[frameNum-1].getScore();
	}
	public int getCurFrame() {
		return curFrame+1;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public FrameStatus throwBall(int pins) {
		if(pins>10) {
			return FrameStatus.Fail;
		}
		if(frames[curFrame]==null) {
			frames[curFrame]=new Frame(pins);
			if(pins==10) ++curFrame;
		} else {
			frames[curFrame].setThrow2(pins);
			++curFrame;
		}
		return frames[curFrame-1].getStatus();
	}
}
