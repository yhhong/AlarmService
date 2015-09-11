package com.aspirecn.demo.alarmservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by yinghuihong on 15/4/28.
 */
public class NotifyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("xxxxxx");
        NotificationUtil.getInstance(context).showNotify();
    }
}
