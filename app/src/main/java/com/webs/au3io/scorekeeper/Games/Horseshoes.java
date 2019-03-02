package com.webs.au3io.scorekeeper.Games;

import android.os.Bundle;
import com.webs.au3io.scorekeeper.ScorableGame;
import com.webs.au3io.scorekeeper.Team;

/**
 * Created by Nicholas Kunzler on 12/27/2016.
 */

public class Horseshoes extends ScorableGame {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState, "Horseshoes");
    }

    @Override
    public void checkScore(Team teamOne, Team teamTwo, boolean includeSkunkRules) {
        if (includeSkunkRules){
            super.skunkScoring(teamOne, teamTwo);
        }
        if (teamOne.getScore() >= 40){
            super.displayWinner(teamOne);
        } else if (teamTwo.getScore() >= 40) {
            super.displayWinner(teamTwo);
        }
    }
}
