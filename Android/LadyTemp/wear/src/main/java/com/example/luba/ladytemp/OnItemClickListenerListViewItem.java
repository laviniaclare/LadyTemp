package com.example.luba.ladytemp;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by luba on 9/28/14.
 */
public class OnItemClickListenerListViewItem implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Context context = view.getContext();
        TextView textViewItem = ((TextView) view.findViewById(R.id.notification));
        int notificationId = 101;
//        // Build intent for notification content
//        Intent viewIntent = new Intent();
//        PendingIntent viewPendingIntent =
//                PendingIntent.getActivity(this, 0, viewIntent, 0);

        //Building notification layout
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.tulip)
                        .setContentTitle("LadyTemp")
                        .setContentText("blah");
                        //.setContentIntent(viewPendingIntent);

        // instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        // Build the notification and notify it using notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }

}
