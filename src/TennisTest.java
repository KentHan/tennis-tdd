import com.line.qa.TennisScore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kent on 2019/6/27.
 */
public class TennisTest {

    private final TennisScore sut = new TennisScore();

    @Test
    public void Love_All() {
        resultShouldBe("Love All");
    }

    @Test
    public void Fifteen_Love() {
        givenPlayerOneScored(1);
        resultShouldBe("Fifteen Love");
    }

    @Test
    public void Thirty_Love() {
        givenPlayerOneScored(2);
        resultShouldBe("Thirty Love");
    }

    @Test
    public void Forty_Love() {
        givenPlayerOneScored(3);
        resultShouldBe("Forty Love");
    }

    @Test
    public void Love_Fifteen() {
        givenPlayerTwoScored(1);
        resultShouldBe("Love Fifteen");
    }

    @Test
    public void Fifteen_All() {
        givenPlayerOneScored(1);
        givenPlayerTwoScored(1);
        resultShouldBe("Fifteen All");
    }

    private void givenPlayerTwoScored(int times) {
        for (int i = 0; i < times; i++) {
            sut.playerTwoScored();
        }
    }

    private void resultShouldBe(String expected) {
        assertEquals(expected, sut.score());
    }

    private void givenPlayerOneScored(int times) {
        for (int i = 0; i < times; i++) {
            sut.playerOneScored();
        }
    }

}
