
package com.aspirecn.demo.alarmservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmUtil {

    /**
     * 设置闹钟
     *
     * @param context
     * @param alarmId
     * @param intent
     * @param triggerAtMills 为0将立即发起alarm
     */
    public static void setupAlarm(Context context, int alarmId, Intent intent, long triggerAtMills) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getBroadcast(context, alarmId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, triggerAtMills, pi);
    }

    /**
     * 设置重复响铃闹钟
     *
     * @param context
     * @param alarmId
     * @param intent
     * @param triggerAtMills
     * @param intervalMills
     */
    public static void setupRepeatedAlarm(Context context, int alarmId, Intent intent, long triggerAtMills, long intervalMills) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getBroadcast(context, alarmId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMills, intervalMills, pi);
    }

    /**
     * 取消闹钟
     *
     * @param context
     * @param alarmId 闹钟唯一标识
     * @param intent
     */
    public static void cancelAlarm(Context context, int alarmId, Intent intent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getBroadcast(context, alarmId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pi);
    }


}
