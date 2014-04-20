package com.example.sound_byte.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by annakrasner & paulzs on 4/19/14.
 */

public class MainActivity extends AppWidgetProvider {

   // Button soundbutton;
    MediaPlayer mPlay;
    public static String ACTION_WIDGET_RECEIVER = "ActionReceiverWidget";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){

        for(int i=0; i<appWidgetIds.length; i++){
            int currentWidgetId = appWidgetIds[i];
            /*String url = "http://www.google.com";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));*/
            Intent soundIntent = new Intent(context, MainActivity.class);
            soundIntent.setAction(ACTION_WIDGET_RECEIVER);
           /* PendingIntent pending = PendingIntent.getActivity(context, 0,
                    intent, 0);*/
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
            if(mPlay != null){
                Toast.makeText(context, "resetting controller", Toast.LENGTH_SHORT).show();
                mPlay.stop();
                mPlay.reset();
                mPlay.start();
            }
            else{
                mPlay = MediaPlayer.create(context, R.raw.oh_myyy);
                mPlay.start();
            }
        }

        super.onReceive(context,intent);
    }




}
