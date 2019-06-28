import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kent on 2019/6/27.
 */
public class TennisTest {

    private final TennisScore sut = new TennisScore("Ace", "Ron");

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

    @Test
    public void Deuce_3_3() {
        givenDeuce();
        resultShouldBe("Deuce");
    }

    @Test
    public void Deuce_4_4() {
        givenDeuce();
        givenPlayerOneScored(1);
        givenPlayerTwoScored(1);
        resultShouldBe("Deuce");
    }

    @Test
    public void Player_One_Adv() {
        givenDeuce();
        givenPlayerOneScored(1);
        resultShouldBe("Ace Adv");
    }

    @Test
    public void Player_Two_Adv() {
        givenDeuce();
        givenPlayerTwoScored(1);
        resultShouldBe("Ron Adv");
    }

    @Test
    public void Score_is_5_3() {
        givenDeuce();
        givenPlayerOneScored(2);
        resultShouldBe("Ace Win");
    }

    @Test
    public void Score_is_2_4() {
        givenPlayerOneScored(2);
        givenPlayerTwoScored(4);
        resultShouldBe("Ron Win");
    }


    private void givenDeuce() {
        givenPlayerOneScored(3);
        givenPlayerTwoScored(3);
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
