package com.SanjayCh.OpenSource.YoutubeAlarm.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.SanjayCh.OpenSource.YoutubeAlarm.Alarm.YoutubeAlarmReciever;
import com.SanjayCh.OpenSource.YoutubeAlarm.data.AlarmData;

import java.util.Calendar;

/**
 * Created by Sanjay on 28-08-2016.
 */
public class AlarmOperations {

    public static void createAlarm(Context context, AlarmData alarmData)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, alarmData.getHour());
        calendar.set(Calendar.MINUTE, alarmData.getMinute());

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context, YoutubeAlarmReciever.class);
        myIntent.putExtra("yt_key",alarmData.getStorageKey());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, alarmData.getAlarmId(), myIntent, PendingIntent.FLAG_UPDATE_CURRENT );

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

    }

    public static void removeAlarm(Context context, AlarmData alarmData){
        Intent intent = new Intent(context, YoutubeAlarmReciever.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, alarmData.getAlarmId(), intent, PendingIntent.FLAG_CANCEL_CURRENT );
        alarmManager.cancel(pendingIntent);
    }
}
