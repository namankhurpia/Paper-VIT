package com.namankhurpia.paper.view.firebaseServices;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.namankhurpia.paper.R;
import com.namankhurpia.paper.view.view.MainActivity;
import com.google.firebase.messaging.RemoteMessage;

public class messaging_service extends FirebaseMessagingService {

    private static final String TAG="Myfirebase,sgservice";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG,"FROM:"+remoteMessage);

        if(remoteMessage.getData().size()>0)
        {
            Log.d(TAG,"Message data"+remoteMessage.getData());
        }

        if(remoteMessage.getNotification()!=null)
        {
            Log.d(TAG,"Message body:"+remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }


    private void sendNotification(String body)
    {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri notification= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifiBuilder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Paper VIT")
                .setContentText(body)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notifiBuilder.build());

    }


}
