package com.example.luba.ladytemp;


import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);

        ListItem[] listItems = new ListItem[4];
        listItems[0] = new ListItem("Lower temperature");
        listItems[1] = new ListItem("Temperature back to normal");
        listItems[2] = new ListItem("Temperature is stable");
        listItems[3] = new ListItem("Period should end");
        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.list_item, listItems);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                String notification = new String();
                int notificationId = 101;
                // Build intent for notification content
                Intent viewIntent = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent viewPendingIntent =
                        PendingIntent.getActivity(getApplicationContext(), 0, viewIntent, 0);
                switch (position) {
                    case 0:
                        notification = "Time to get babies!";
                        break;
                    case 1:
                        notification = "Your period is expected tomorrow!";
                        break;
                    case 2:
                        notification = "Your period is expected today!";
                        break;
                    case 3:
                        notification = "Your period should end today!";

                }

                //Building notification layout
                NotificationCompat.Builder notificationBuilder =
                        new NotificationCompat.Builder(getBaseContext())
                                .setSmallIcon(R.drawable.tulip)
                                .setContentTitle("LadyTemp")
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.tulip))
                                .setContentText(notification)
                                .setContentIntent(viewPendingIntent);
                if (position == 2) {
                    notificationBuilder.addAction(R.drawable.circle, "Start Period", getStartIntent());
                } else if(position == 3) {
                    notificationBuilder.addAction(R.drawable.circle, "End Period", getEndIntent());
                }

                // instance of the NotificationManager service
                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(getApplicationContext());

                // Build the notification and notify it using notification manager.
                notificationManager.notify(notificationId, notificationBuilder.build());
            }
        });
    }

    public PendingIntent getStartIntent(){
        // Build an intent for an action to open a url
        Intent intent = new Intent(this, CongratsActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent, 0);

        return pendingIntent;
    }

    public PendingIntent getEndIntent(){
        // Build an intent for an action to open a url
        Intent intent = new Intent(this, EndPeriodActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent, 0);

        return pendingIntent;
    }


}
