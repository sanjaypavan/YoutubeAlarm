package com.example.sanjay.youtubeAlarm.Alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.example.sanjay.youtubeAlarm.data.AlarmData;
import com.example.sanjay.youtubeAlarm.utils.StorageOperations;

/**
 * Created by Sanjay on 27-08-2016.
 */
public class YoutubeAlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String preferencesKey = intent.getExtras().getString("yt_key");
        Log.e("In Receiver", preferencesKey);

        AlarmData alarmData = StorageOperations.getAlarmData(context, preferencesKey);
        //Intent I = YouTubeIntents.createPlayVideoIntent(context,"BJ4TlYhoKPY");
        //I.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(I);


        Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=BJ4TlYhoKPY?autoplay=1"));
        I.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(I);
    }
}
