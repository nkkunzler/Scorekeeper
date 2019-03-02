package com.webs.au3io.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.webs.au3io.scorekeeper.Games.BeanBagToss;
import com.webs.au3io.scorekeeper.Games.BocceBall;
import com.webs.au3io.scorekeeper.Games.Horseshoes;
import com.webs.au3io.scorekeeper.Games.LadderGolf;
import com.webs.au3io.scorekeeper.Games.Washers;

public class InformationScreen extends AppCompatActivity {

    private String gameTitle;
    private Switch skunkRuleSwitch;

    /*
     * Creates the information_screen.xml and sets the title of the activity to string passed
     * through the intent from the HomeScreen class. Constructs the skunkRule switch for use in the
     * onClick(View view) method.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_screen);

        gameTitle = getIntent().getStringExtra("gameName");
        setTitle(gameTitle + " - Information");

        skunkRuleSwitch = (Switch) findViewById(R.id.skunkRuleSwitch);
    }

    /*
     * When the two buttons on the information screen (Cancel, Continue) are clicked this method will
     * be called.
     *
     * If the cancel button is clicked, the information activity will close and send you back to the
     * home screen.
     *
     * If the continue button is clicked, the score_screen.xml opens and sends the appropriate
     * information (TeamOne name, TeamTwo name, if skunkRules will be applied), and starts the
     * score_screen activity. It will then close this activity (information_screen.xml).
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.continueBtn:
                Intent intent;
                if (gameTitle.equals("Bean Bag Toss")) {
                    intent = new Intent(this, BeanBagToss.class);
                    Log.i("info", "bean bag toss");
                } else if (gameTitle.equals("Bocce Ball")) {
                    intent = new Intent(this, BocceBall.class);
                } else if (gameTitle.equals("Washers")) {
                    intent = new Intent(this, Washers.class);
                } else if (gameTitle.equals("Ladder Golf")){
                    intent = new Intent(this, LadderGolf.class);
                } else{
                    intent = new Intent(this, Horseshoes.class);
                }

                intent.putExtra("teamOneName", ((EditText) findViewById(R.id.teamOneInputName)).getText().toString());
                intent.putExtra("teamTwoName", ((EditText) findViewById(R.id.teamTwoInputName)).getText().toString());
                intent.putExtra("skunkRule", skunkRuleSwitch.isChecked());
                startActivity(intent);
                finish();
                break;

            case R.id.infoBtn:
                break;

            case R.id.cancelBtn:
                finish();
                break;

        }
    }
}
