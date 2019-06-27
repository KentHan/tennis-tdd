package com.line.qa;

import java.util.HashMap;

/**
 * Created by Kent on 2019/6/27.
 */
public class TennisScore {
    private int playerOneScore;
    private HashMap<Integer, String> map = new HashMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};
    private int playerTwoScore;

    public String score() {
        if (playerOneScore == playerTwoScore) {
            return map.get(playerTwoScore) + " All";
        }

        if (playerTwoScore > 0) {
            return "Love " + map.get(playerTwoScore);
        }

        if (playerOneScore > 0) {
            return map.get(playerOneScore) + " Love";
        }
        return "";
    }

    public void playerOneScored() {
        playerOneScore++;
    }

    public void playerTwoScored() {
        playerTwoScore++;
    }
}
