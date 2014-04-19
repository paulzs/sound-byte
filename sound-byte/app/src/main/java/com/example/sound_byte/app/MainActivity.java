package com.example.sound_byte.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RemoteViews;

/**
 * Created by annakrasner & paulzs on 4/19/14.
 */

public class MainActivity extends Activity{

    Button soundbutton;
    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundbutton = (Button) findViewById(R.id.button);
        mp = MediaPlayer.create(MainActivity.this,R.raw.oh_myyy);

        soundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  mp.start();
            }
        });
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/

}
