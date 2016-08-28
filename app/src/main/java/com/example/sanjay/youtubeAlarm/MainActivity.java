package com.example.sanjay.youtubeAlarm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.sanjay.youtubeAlarm.data.AlarmData;
import com.example.sanjay.youtubeAlarm.utils.AlarmListAdapter;
import com.example.sanjay.youtubeAlarm.utils.StorageOperations;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();

        List<AlarmData> alarmDataList =  StorageOperations._getAllAlarmData(context);

        List<String> alarmTimings = new ArrayList<String>();

        for (AlarmData a: alarmDataList) {
            alarmTimings.add(a.getHour()+":"+a.getMinute());
        }

        AlarmListAdapter adapter = new AlarmListAdapter(this, R.layout.alarm_item, R.id.alarm_item_text_view, alarmDataList );

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.alarm_item, R.id.alarm_item_text_view, alarmTimings);
        ListView listView = (ListView) this.findViewById(R.id.alarm_list);

        listView.setAdapter(adapter);
    }

//    private void dummyEntryForAlaramData(Context context)
//    {
//        int hour = 14;
//        int minute = 20;
//        String url = "SomeString";
//
//        AlarmData sampleData = new AlarmData(hour, minute, url);
//        StorageOperations.saveAlarmData(context, sampleData);
//    }

    public void addNewAlarm(View view)
    {
        Intent intent = new Intent(this, AlarmSelectionActivity.class);
        startActivity(intent);

        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }


}
