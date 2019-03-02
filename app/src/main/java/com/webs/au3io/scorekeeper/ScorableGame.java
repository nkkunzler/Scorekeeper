package com.webs.au3io.scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Nicholas Kunzler on 12/17/2016.
 */

public abstract class ScorableGame extends AppCompatActivity {

    private Team teamOne, teamTwo;
    private boolean useSkunkRules;

    /*
     * Opens score_screen.xml from the activity information_screen.xml
     *
     * Intent information passed form the information_screen.xml is used to created a new instance
     * of Teams (TeamOne, TeamTwo). It takes the inputted names from the information screen and
     * changes the team names in score_screen.xml. If these names are emtpy a default names is given
     * ("Team One", "Team Two").
     */
    protected void onCreate(Bundle savedInstanceState, String title){
        super.onCreate(savedInstanceState);
        if (title.equals("Bean Bag Toss")){
            setContentView(R.layout.score_screen_bean_bag);
        } else {
            setContentView(R.layout.score_screen);
        }
        setTitle(title);

        useSkunkRules = getIntent().getExtras().getBoolean("skunkRule");

        String teamOneName = getIntent().getStringExtra("teamOneName");
        String teamTwoName = getIntent().getStringExtra("teamTwoName");

        if (teamOneName.equals("")){
            teamOneName = "Team One";
        }
        if (teamTwoName.equals("")){
            teamTwoName = "Team Two";
        }

        TextView teamOneNameText = (TextView) findViewById(R.id.teamOneNameTextField);
        TextView teamTwoNameText = (TextView) findViewById(R.id.teamTwoNameTextField);

        TextView teamOneScoreText = (TextView) findViewById(R.id.teamOneScoreText);
        TextView teamTwoScoreText = (TextView) findViewById(R.id.teamTwoScoreText);

        teamOne = new Team(teamOneName, teamOneScoreText, teamOneNameText);
        teamTwo = new Team(teamTwoName, teamTwoScoreText, teamTwoNameText);
    }

    /*
     * This method is called when the buttons on score_screen.xml is pressed.
     *
     * This method takes the input from the buttons and updates the score for the corresponding
     * team. It then calls the method checkScore.
     */
    public void updateScore(View view){

        switch(view.getId()){

            case R.id.minusOneTeamOneBtn:
                teamOne.incrementScore(-1);
                break;

            case R.id.plusOneTeamOneBtn:
                teamOne.incrementScore(1);
                break;

            case R.id.plusTwoTeamOneBtn:
                teamOne.incrementScore(2);
                break;

            case R.id.plusThreeTeamOneBtn:
                teamOne.incrementScore(3);
                break;

            case R.id.plusFourTeamOneBtn:
                teamOne.incrementScore(4);
                break;

            case R.id.minusOneTeamTwoBtn:
                teamTwo.incrementScore(-1);
                break;

            case R.id.plusOneTeamTwoBtn:
                teamTwo.incrementScore(1);
                break;

            case R.id.plusTwoTeamTwoBtn:
                teamTwo.incrementScore(2);
                break;

            case R.id.plusThreeTeamTwoBtn:
                teamTwo.incrementScore(3);
                break;

            case R.id.plusFourTeamTwoBtn:
                teamTwo.incrementScore(4);
                break;
        }

        checkScore(teamOne, teamTwo, useSkunkRules);
    }
    //This method is to be used in the Games classes
    public abstract void checkScore(Team teamOne, Team teamTwo, boolean includeSkunkRules);

    /*
     * If the skunk rule switch is checked from the information_screen.xml this method will be
     * called from the games.
     */
    public void skunkScoring(Team teamOne, Team teamTwo){
        if (teamOne.getScore() >= 11 && teamTwo.getScore() == 0) {
            displayWinner(teamOne);
        } else if (teamTwo.getScore() >= 11 && teamOne.getScore() == 0) {
            displayWinner(teamTwo);
        }
    }

    /*
     * This method is called when a Team reaches the required points in order to win the game.
     * It changes activity to the winner_screen.xml
     */
    public void displayWinner(Team winningTeam){
        Intent intent = new Intent(ScorableGame.this, WinnerScreen.class);
        intent.putExtra("winningTeamName", winningTeam.getName());
        startActivity(intent);
        teamOne.setScore(0);
        teamTwo.setScore(0);
    }
}
