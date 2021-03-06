package com.example.sound_byte.app;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by annakrasner & paulzs on 4/19/14.
 */

public class MainActivity extends AppWidgetProvider {

   // Button soundbutton;
    private static MediaPlayer mPlay;
    public static String ACTION_WIDGET_RECEIVER = "ActionReceiverWidget";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){

        for(int i=0; i<appWidgetIds.length; i++){
            int currentWidgetId = appWidgetIds[i];
            Intent soundIntent = new Intent(context, MainActivity.class);
            soundIntent.setAction(ACTION_WIDGET_RECEIVER);
            PendingIntent pending = PendingIntent.getBroadcast(context, 0, soundIntent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.activity_main);
            views.setOnClickPendingIntent(R.id.main_button, pending);
            appWidgetManager.updateAppWidget(currentWidgetId,views);
            Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals(ACTION_WIDGET_RECEIVER))
        {
            if(mPlay == null){ //If soundclip is not already playing, create and play
                mPlay = MediaPlayer.create(context, R.raw.oh_myyy);
                mPlay.start();
            }
            else if(mPlay.isPlaying()){ //If already playing, rewind to beginning and play to avoid echo effect
                mPlay.seekTo(0);
            }
            else{
                mPlay.start();
            }
        }

        super.onReceive(context, intent);
    }

}
