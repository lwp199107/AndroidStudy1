package com.example.userlogin;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Aslan on 2016/9/7.
 */
public class Notify extends Activity {
    public static final int NOTIFICATION_FLAG = 1;
    NotificationManager nm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
       nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private void setView() {
        setContentView(R.layout.notification);
    }
    public void notification(View view) {
        Intent itent=new Intent(this,DemoActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,itent,0);

        Notification n=new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentText("逗你玩呢")
                .setContentTitle("打开,有好玩的哦")
                .setTicker("有新消息啦")
                .setContentIntent(pendingIntent)
                .getNotification();
        n.flags|=Notification.FLAG_AUTO_CANCEL;
        nm.notify(NOTIFICATION_FLAG,n);
    }
}

