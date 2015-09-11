package com.aspirecn.demo.alarmservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by yinghuihong on 15/4/27.
 */
public class NotifyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
//        NotifyThread thread = new NotifyThread(this);
//        thread.start();

        NotificationUtil.getInstance(this).showNotify();
    }
}
