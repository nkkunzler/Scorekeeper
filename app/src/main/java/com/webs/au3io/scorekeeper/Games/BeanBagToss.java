package com.webs.au3io.scorekeeper.Games;

import android.os.Bundle;
import android.util.Log;

import com.webs.au3io.scorekeeper.ScorableGame;
import com.webs.au3io.scorekeeper.Team;
import com.webs.au3io.scorekeeper.WinnerScreen;

import java.io.Serializable;

/**
 * Created by Nicholas Kunzler on 12/17/2016.
 */

public class BeanBagToss extends ScorableGame{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState, "Bean Bag Toss");
    }

    @Override
    public void checkScore(Team teamOne, Team teamTwo, boolean includeSkunkRules) {
        if (includeSkunkRules){
            super.skunkScoring(teamOne, teamTwo);
        }

        if (teamOne.getScore() < 0){
            teamOne.setScore(0);
        } else if (teamTwo.getScore() < 0){
            teamTwo.setScore(0);
        } else if (teamOne.getScore() == 21){
            super.displayWinner(teamOne);
        } else if (teamTwo.getScore() == 21){
            super.displayWinner(teamTwo);
        } else if (teamOne.getScore() > 21){
            teamOne.setScore(17);
        } else if (teamTwo.getScore() > 21){
            teamTwo.setScore(17);
        }
    }
}
