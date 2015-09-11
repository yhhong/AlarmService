package com.aspirecn.demo.alarmservice;

import android.content.Context;

/**
 * Created by yinghuihong on 15/4/27.
 */
public class NotifyThread extends Thread {

    private Context mContext;

    private boolean mRun;

    public NotifyThread(Context context) {
        super();
        this.setDaemon(true);
        this.mContext = context;
        mRun = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                NotificationUtil.getInstance(mContext).showNotify();
                synchronized (this) {
                    if (mRun) {
                        this.wait(3000);
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
