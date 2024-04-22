package com.jake.tracking;
import android.app.NotificationChannel;

public class NotificationTestService {

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Notification Channel";
            String description = "Channel for Notification Test";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("NOTIFY_ID", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
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
