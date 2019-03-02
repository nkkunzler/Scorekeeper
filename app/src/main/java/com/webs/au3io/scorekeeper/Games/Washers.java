package com.webs.au3io.scorekeeper.Games;

import android.os.Bundle;
import com.webs.au3io.scorekeeper.ScorableGame;
import com.webs.au3io.scorekeeper.Team;

/**
 * Created by Nicholas Kunzler on 12/17/2016.
 */

public class Washers extends ScorableGame {

    private boolean needDifferenceOfTwo = false;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState, "Washers");
    }

    public void checkScore(Team teamOne, Team teamTwo, boolean includeSkunkRules) {

        int scoreDifference = Math.abs(teamOne.getScore() - teamTwo.getScore());

        if (includeSkunkRules){
            super.skunkScoring(teamOne, teamTwo);
        }
        if (needDifferenceOfTwo){
            if (scoreDifference >= 2){
                if (teamOne.getScore() > teamTwo.getScore()){
                    displayWinner(teamOne);
                    needDifferenceOfTwo = false;
                } else if (teamOne.getScore() < teamTwo.getScore()){
                    displayWinner(teamTwo);
                    needDifferenceOfTwo = false;
                }
            }
        }
        else if (teamOne.getScore() == 20 && teamTwo.getScore() == 21) {
            needDifferenceOfTwo = true;
        } else if (teamTwo.getScore() == 20 && teamOne.getScore() == 21) {
            needDifferenceOfTwo = true;
        } else if (teamOne.getScore() >= 21) {
            super.displayWinner(teamOne);
        } else if (teamTwo.getScore() >= 21) {
            super.displayWinner(teamTwo);
        }
    }
}
