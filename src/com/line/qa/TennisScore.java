package com.line.qa;

import java.util.HashMap;

import static java.lang.Math.abs;

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
    private String playerOneName;
    private String playerTwoName;

    public TennisScore(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String score() {

        if (playerOneScore == playerTwoScore) {
            if (playerOneScore >= 3) {
                return "Deuce";
            }
            return map.get(playerTwoScore) + " All";
        }

        if (playerOneScore >= 3 && playerTwoScore >= 3) {
            if (abs(playerOneScore - playerTwoScore) == 1) {
                return playerOneScore > playerTwoScore ? playerOneName + " Adv" : playerTwoName + " Adv";
            } else {
                return playerOneScore > playerTwoScore ? playerOneName + " Win" : playerTwoName + " Win";
            }
        }

        if ((playerOneScore >= 4 || playerTwoScore >= 4) && (abs(playerOneScore - playerTwoScore) >= 2)) {
            return playerOneScore > playerTwoScore ? playerOneName + " Win" : playerTwoName + " Win";
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
