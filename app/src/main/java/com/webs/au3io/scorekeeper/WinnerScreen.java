package com.webs.au3io.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinnerScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_screen);
        setTitle("Winner - "  + getIntent().getStringExtra("winningTeamName"));

        TextView winningTeamName = (TextView) findViewById(R.id.winningTeamName);
        winningTeamName.setText(getIntent().getStringExtra("winningTeamName"));
    }

    /*
     * This method is called if the two buttons on the winner_screen.xml are pressed (Replay, To Menu)
     *
     * If the user presses the replay button winner_screen.xml closes and the score_screen is
     * visible.
     *
     * If the user presses the mainMenuButton, all activities (Winner Screen and scoring screen) are
     * finished and the home screen becomes visible.
     */
    public void onClick(View view){
        Intent intent;

        switch(view.getId()){
            case R.id.replayBtn:
                finish();
                break;

            case R.id.mainMenuBtn:
                intent = new Intent(WinnerScreen.this, HomeScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }
}
