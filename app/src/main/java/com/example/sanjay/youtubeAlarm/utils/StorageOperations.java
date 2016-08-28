package com.example.sanjay.youtubeAlarm.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sanjay.youtubeAlarm.data.AlarmData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sanjay on 26-08-2016.
 */
public class StorageOperations {


    public static String PREF = "YT_ALARM";


    public static void saveAlarmData(Context context, AlarmData alarmData)
    {
        String key = alarmData.getStorageKey();
        SharedPreferences preferences = context.getSharedPreferences(PREF,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(key, alarmData.toString());


        editor.apply();

    }

    public static void removeAlarmData(Context context, AlarmData alarmData)
    {
        SharedPreferences preferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.remove(alarmData.getStorageKey());
        editor.apply();
    }

    public static AlarmData getAlarmData(Context context, String key)
    {
        SharedPreferences preferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        String alarmDataJson = preferences.getString(key, "Nothing");
        AlarmData alarmData = fromJson(alarmDataJson);
        return alarmData;
    }

    public static List<AlarmData> _getAllAlarmData(Context context)
    {
        List<AlarmData> alarmDataList = new ArrayList<AlarmData>();
        SharedPreferences preferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);

        Map<String, ?> keys = preferences.getAll();

        for(Map.Entry<String, ?> entry: keys.entrySet())
        {
            if(fromJson(entry.getValue().toString()) != null)
            {
                alarmDataList.add(fromJson(entry.getValue().toString()));
            }
        }

        return  alarmDataList;
    }

    private static AlarmData fromJson(String json)
    {
        try
        {
            JSONObject obj = new JSONObject(json);
            int hour = obj.getInt("hour");
            int minute = obj.getInt("minute");
            String ytURL = obj.getString("youtubeURL");
            int alarmId = obj.getInt("alarmId");

            return new AlarmData(alarmId,hour, minute, ytURL);
        }
        catch (JSONException ex)
        {

        }

        return null;
    }
}
