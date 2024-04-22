package com.jake.tracking;
import static androidx.core.content.ContextCompat.getSystemService;

import android.app.NotificationChannel;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationManagerCompat;


public class NotificationTestService {

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Notification Channel";
            String description = "Channel for Notification Test";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("NOTIFY_ID", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "NOTIFY_ID")
                .setSmallIcon(R.drawable.ic_notification)  // Set the icon
                .setContentTitle("Test Notification")     // Set the title of notification
                .setContentText("Hello from your service!")  // Content of notification
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());
    }

}
