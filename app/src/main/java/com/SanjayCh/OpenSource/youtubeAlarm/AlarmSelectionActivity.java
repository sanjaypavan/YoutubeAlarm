package com.SanjayCh.OpenSource.youtubeAlarm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.SanjayCh.OpenSource.youtubeAlarm.data.AlarmData;
import com.SanjayCh.OpenSource.youtubeAlarm.utils.AlarmOperations;
import com.SanjayCh.OpenSource.youtubeAlarm.utils.StorageOperations;

public class AlarmSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_selection);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textview = new TextView(this);
        textview.setTextSize(40);
        textview.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_alarm_selection);
        layout.addView(textview);
    }


    public void alarmTimeSelected(View view)
    {
        TimePicker timePicker = (TimePicker) findViewById(R.id.time_picker);
        EditText youtubeURL = (EditText) findViewById(R.id.youtube_url);
        Context context  = getApplicationContext();

        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        final int alarmId = (int)System.currentTimeMillis();
        AlarmData alarmData = new AlarmData(alarmId, hour, minute, youtubeURL.getText().toString());

        StorageOperations.saveAlarmData(context, alarmData);

        AlarmOperations.createAlarm(context, alarmData);

        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    
}
