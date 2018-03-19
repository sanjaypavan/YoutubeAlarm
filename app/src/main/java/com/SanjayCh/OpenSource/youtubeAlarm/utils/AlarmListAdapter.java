package com.SanjayCh.OpenSource.youtubeAlarm.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.SanjayCh.OpenSource.youtubeAlarm.R;
import com.SanjayCh.OpenSource.youtubeAlarm.data.AlarmData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sanjay on 28-08-2016.
 */
public class AlarmListAdapter extends ArrayAdapter<AlarmData>{
    List<AlarmData> alarmDataList = new ArrayList<AlarmData>();

    public AlarmListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public AlarmListAdapter(Context context, int resource, int textViewResourceId, List<AlarmData> alarmDataList) {
        super(context, resource, textViewResourceId, alarmDataList);
        this.alarmDataList = alarmDataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;

        if(view  == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.alarm_item, null);
        }

        final AlarmData thisAlarmData = getItem(position);

        if(thisAlarmData != null){

            //Set the text in the text view
            TextView timeElem = (TextView) view.findViewById(R.id.alarm_item_text_view);
            if(timeElem != null){
                timeElem.setText(thisAlarmData.getHour()+":"+ thisAlarmData.getMinute());
            }

            Button deleteButton = (Button) view.findViewById(R.id.delete_alarm_item);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    StorageOperations.removeAlarmData(getContext(), thisAlarmData);
                    AlarmOperations.removeAlarm(getContext(),thisAlarmData);
                    alarmDataList.remove(thisAlarmData);
                    notifyDataSetChanged();

                }
            });
        }

        return  view;
    }

}
