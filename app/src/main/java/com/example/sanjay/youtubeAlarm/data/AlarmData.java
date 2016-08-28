package com.example.sanjay.youtubeAlarm.data;

/**
 * Created by Sanjay on 26-08-2016.
 */
public class AlarmData {
    int hour;
    int minute;
    String youtubeURL;
    int alarmId;

    public AlarmData(int alarmId, int hour, int minute, String youtubeURL) {
        this.hour = hour;
        this.minute = minute;
        this.youtubeURL = youtubeURL;
    }

    public int getHour() {
        return hour;
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getYoutubeURL() {
        return youtubeURL;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }

    @Override
    public String toString() {
        return "{" +
                " hour:" + hour +
                ", minute:" + minute +
                ", youtubeURL:'" + youtubeURL + '\'' +
                ", alarmId:" + alarmId +
                '}';
    }

    public String getStorageKey(){
        return hour+":"+minute+":"+youtubeURL;
    }
}
