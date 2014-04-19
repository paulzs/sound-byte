package com.example.sound_byte.app;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by annakrasner & paulzs on 4/19/14.
 */
public class SoundButton extends AppWidgetProvider {

    public void onEnabled(Context context){
        // Get the layout for the App Widget and attach an on-click listener
        // to the button
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.soundbutton_layout);
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.button, pendingIntent);
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.soundbutton_layout);
        // find your TextView here by id here and update it.
        Toast.makeText(context, "Clicked!!", Toast.LENGTH_SHORT).show();
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.soundbutton_layout);
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.button, pendingIntent);
    }

}
