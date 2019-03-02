package com.webs.au3io.scorekeeper;

import android.widget.TextView;

/**
 * Created by Nicholas Kunzler on 12/17/2016.
 */

public class Team{
    private int score;
    private String teamName;
    private TextView scoreText, nameText;

    public Team(String teamName, TextView scoreText, TextView nameText){
        this.teamName = teamName;
        this.scoreText = scoreText;
        this.nameText = nameText;

        nameText.setText(teamName);

        score = 0;
    }

    public void incrementScore(int amount){
        score += amount;
        scoreText.setText("Score: " + score);
    }

    public void setScore(int amount){
        score = amount;
        scoreText.setText("Score: " + score);
    }

    public void setName(String name){
        teamName = name;
        nameText.setText("Score: 50");
    }

    public int getScore(){
        return score;
    }

    public String getName(){
        return teamName;
    }
}
