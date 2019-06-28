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

        if (samePoint()) {
            if (playerOneScore >= 3) {
                return "Deuce";
            } else {
                return map.get(playerOneScore) + " All";
            }
        }

        if (afterDeuce() && scoreDiff() == 1) {
            return playerOneScore > playerTwoScore ? playerOneName + " Adv" : playerTwoName + " Adv";
        }

        if ((playerOneScore >= 4 || playerTwoScore >= 4) && scoreDiff() >= 2) {
            return playerOneScore > playerTwoScore ? playerOneName + " Win" : playerTwoName + " Win";
        }

        return map.get(playerOneScore) + " " + map.get(playerTwoScore);
    }

    private boolean samePoint() {
        return playerOneScore == playerTwoScore;
    }

    private int scoreDiff() {
        return abs(playerOneScore - playerTwoScore);
    }

    private boolean afterDeuce() {
        return playerOneScore >= 3 && playerTwoScore >= 3;
    }

    public void playerOneScored() {
        playerOneScore++;
    }

    public void playerTwoScored() {
        playerTwoScore++;
    }
}
