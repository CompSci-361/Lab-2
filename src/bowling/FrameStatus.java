package bowling;

public enum FrameStatus {
	Fail(-2),
	Empty(-1),
	FirstComplete(0),
	Full(1),
	Strike(2),
	Spare(3);

    private int value;

    private FrameStatus(int value) {
         this.value = value;
    }
}
