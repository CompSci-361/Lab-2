package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ScoreSheetTest {

    @Test
    public void testOneThrow() throws Exception {
        ScoreSheet scoreSheet = new ScoreSheet();

        scoreSheet.throwBall(5);

        assertEquals(5, scoreSheet.getFrameScore(1));

        assertEquals(5, scoreSheet.getTotalScore());
    }



    @Test
    public void testTwoThrow() throws Exception {

        ScoreSheet scoreSheet = new ScoreSheet();

        scoreSheet.throwBall(2);

        scoreSheet.throwBall(7);

        assertEquals(9, scoreSheet.getFrameScore(1));

        assertEquals(9, scoreSheet.getTotalScore());

    }



    @Test
    public void testThreeThrow() throws Exception {
        ScoreSheet scoreSheet = new ScoreSheet();

        scoreSheet.throwBall(2);

        scoreSheet.throwBall(7);

        assertEquals(9, scoreSheet.getFrameScore(1));

        scoreSheet.throwBall(2);

        assertEquals(2, scoreSheet.getFrameScore(2));

        assertEquals(11, scoreSheet.getTotalScore());
    }



    @Test
    public void testSpareCountsNextFrameScore() throws Exception {
        ScoreSheet scoreSheet = new ScoreSheet();

        //spare

        scoreSheet.throwBall(4);

        scoreSheet.throwBall(6);

        assertEquals(10, scoreSheet.getFrameScore(1));

        scoreSheet.throwBall(2);

        //frame 1 would become 12 (10 + 2 of the first roll of the second frame)

        assertEquals(12, scoreSheet.getFrameScore(1));

        assertEquals(2, scoreSheet.getFrameScore(2));

        assertEquals(14, scoreSheet.getTotalScore());

        scoreSheet.throwBall(7);

        assertEquals(9, scoreSheet.getFrameScore(2));
        assertEquals(21, scoreSheet.getTotalScore());
    }



    @Test
    public void testStrikeMovesToNextFrame() throws Exception {
        ScoreSheet scoreSheet = new ScoreSheet();
        scoreSheet.throwBall(10);
        assertEquals(2, scoreSheet.getCurrentFrame());
    }

    @Test
    public void testStrikeCountsNextFrameScore() throws Exception {
        ScoreSheet scoreSheet = new ScoreSheet();

        //strike
        scoreSheet.throwBall(10);

        assertEquals(10, scoreSheet.getFrameScore(1));

        scoreSheet.throwBall(2);

        assertEquals(12, scoreSheet.getFrameScore(1));
        assertEquals(2, scoreSheet.getFrameScore(2));

        scoreSheet.throwBall(4);

        //frame 1 would become 12 (10 + 2 + 4 of the first two roll of the second frame)
        assertEquals(16, scoreSheet.getFrameScore(1));
        assertEquals(6, scoreSheet.getFrameScore(2));
        assertEquals(22, scoreSheet.getTotalScore());
    }



    @Test
    public void testSpareOnLastFrame() throws Exception {
        ScoreSheet scoreSheet = new ScoreSheet();

        for(int i = 0; i < 9; i++){
            scoreSheet.throwBall(0);
            scoreSheet.throwBall(1);
        }

        assertEquals(9, scoreSheet.getTotalScore());

        scoreSheet.throwBall(5);

        scoreSheet.throwBall(5);

        assertEquals(10, scoreSheet.getFrameScore(10));
        assertEquals(19, scoreSheet.getTotalScore());

        
        //in regular bowling, a third throw here is valid. we aren't told to test for turkeys on the final frame so we won't test here.
        /*scoreSheet.throwBall(5);

        assertEquals(15, scoreSheet.getFrameScore(10));
        assertEquals(10, scoreSheet.getCurrentFrame());
        assertEquals(24, scoreSheet.getTotalScore());*/
    }



    @Test
    public void testStrikeOnLastFrames() throws Exception {
        //test on frames 8, 9, 10
        ScoreSheet scoreSheet = new ScoreSheet();
        
        for(int i = 0; i < 7; i++){
            scoreSheet.throwBall(0);
            scoreSheet.throwBall(1);
        }

        assertEquals(7, scoreSheet.getTotalScore());
        scoreSheet.throwBall(10);
        assertEquals(8, scoreSheet.getCurrentIndex());
        assertEquals(17, scoreSheet.getTotalScore());


        scoreSheet.throwBall(10);

        assertEquals(9, scoreSheet.getCurrentIndex());
        assertEquals(20, scoreSheet.getFrameScore(8));
        assertEquals(37, scoreSheet.getTotalScore());


        scoreSheet.throwBall(10);
        assertEquals(10, scoreSheet.getCurrentIndex());
        assertEquals(30, scoreSheet.getFrameScore(8));
        assertEquals(20, scoreSheet.getFrameScore(9));

        assertEquals(67, scoreSheet.getTotalScore());

    }

    @Test(expected = Exception.class)
    public void testThrowOn11thFrame() throws Exception {
        ScoreSheet scoreSheet = new ScoreSheet();

        for(int i = 0; i < 10; i++){ //skip to 10th frame
            scoreSheet.throwBall(0);

            scoreSheet.throwBall(1);
        }

        //throw on 11th frame
        scoreSheet.throwBall(5);
    }

}
