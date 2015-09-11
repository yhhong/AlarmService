package com.aspirecn.demo.alarmservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

/**
 * 顶部栏通知
 */
public class NotificationUtil {

    /**
     * Notification的ID
     */
    int notifyId = 10000;

    private static NotificationUtil instance;
    /**
     * Notification管理
     */
    private NotificationManager mNotificationManager;
    /**
     * Notification构造器
     */
    NotificationCompat.Builder mBuilder;

    private Context mContext;

    public static NotificationUtil getInstance(Context context) {
        if (null == instance) {
            instance = new NotificationUtil(context);
        }
        return instance;
    }

    private NotificationUtil(Context context) {
        this.mContext = context;
        mNotificationManager = (NotificationManager) mContext
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    /**
     * 显示自定义通知栏
     */
    public void showNotify() {
        clearNotify();
        // 设定RemoteViews
        RemoteViews view_custom = new RemoteViews(mContext.getPackageName(), R.layout.notification);
//			// 设置对应IMAGEVIEW的ID的资源图片
//			view_custom.setImageViewResource(R.id.custom_icon,
//					reImageResource());
//			view_custom.setTextViewText(R.id.tv_custom_title,
//					setMessageTittle());
//			view_custom.setTextViewText(R.id.tv_custom_content,
//					setApplicationState());

        mBuilder = new NotificationCompat.Builder(mContext);
        mBuilder.setContentIntent(
                getDefalutIntent(Notification.FLAG_AUTO_CANCEL))
                // 通知产生的时间，会在通知信息里显示
                .setOngoing(true)
                        // 设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setSmallIcon(R.drawable.abc_ic_commit_search_api_mtrl_alpha)
                .setDefaults(Notification.DEFAULT_ALL)
                .setDefaults(Notification.DEFAULT_LIGHTS)
                        // 设置闪烁提示
                        // .setDefaults(Notification.DEFAULT_ALL)
                .setContent(view_custom)
                        // 点击后让通知将消失
                .setAutoCancel(true)
                .setContentIntent(
                        getDefalutIntent(Notification.FLAG_NO_CLEAR))
                .setContentIntent(
                        getDefalutIntent(Notification.FLAG_ONGOING_EVENT));
        // .setWhen(System.currentTimeMillis())// 通知产生的时间，会在通知信息里显示
        // .setTicker("新闻资讯").setOngoing(false)// 不是正在进行的 true为正在进行
        // .setSmallIcon(R.drawable.app_icon);

        Notification notify = mBuilder.build();
        notify.contentView = view_custom;

//			Intent resultIntent = new Intent(
//					mContext,
//					com.aspirecn.corpsocial.bundle.common.ui.LoginActivity_.class);
//			resultIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//			PendingIntent pendingIntent = PendingIntent.getActivity(mContext,
//					notifyId, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//			mBuilder.setContentIntent(pendingIntent);
        mNotificationManager.notify(notifyId, mBuilder.build());
        // return;
    }

    /**
     * @获取默认的pendingIntent,为了防止2.3及以下版本报错
     * @flags属性: 在顶部常驻:Notification.FLAG_ONGOING_EVENT 点击去除：
     * Notification.FLAG_AUTO_CANCEL
     */
    public PendingIntent getDefalutIntent(int flags) {
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 1,
                new Intent(), flags);
        return pendingIntent;
    }

    /**
     * 清除你发通知栏
     */
    public void clearNotify() {
        if (null != mNotificationManager) {
            // mNotificationManager.cancelAll();// 删除你发的所有通知
            mNotificationManager.cancel(notifyId);
        }
    }

    /**
     * 清除所有通知
     */
    public void clearAllNotify() {
        if (mNotificationManager != null) {
            mNotificationManager.cancelAll();
        }
    }

}
