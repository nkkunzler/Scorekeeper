package com.webs.au3io.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.webs.au3io.scorekeeper.Games.BeanBagToss;
import com.webs.au3io.scorekeeper.Games.BocceBall;
import com.webs.au3io.scorekeeper.Games.Horseshoes;
import com.webs.au3io.scorekeeper.Games.LadderGolf;
import com.webs.au3io.scorekeeper.Games.Washers;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        setTitle("Scorekeeper");
    }
    /*
     * When a user clicks one of the game buttons in the home_screen.xml file it creates a new
     * intent to open the information screen. The game title is sent through the intent by putExtra
     * and then the information is received in the InformationScreen class.
     */
    public void onClick(View view) {

        Intent intent = new Intent(this, InformationScreen.class);

        switch(view.getId()){
            case R.id.beanBagBtn:
                intent.putExtra("gameName", "Bean Bag Toss");
                break;

            case R.id.bocceBallBtn:
                intent.putExtra("gameName", "Bocce Ball");
                break;

            case R.id.washersBtn:
                intent.putExtra("gameName", "Washers");
                break;

            case R.id.ladderGolfBtn:
                intent.putExtra("gameName", "Ladder Golf");
                break;

            case R.id.horseshoeBtn:
                intent.putExtra("gameName", "Horseshoes");
                break;
        }

        startActivity(intent);
    }
}
