package space.traner.myfitness.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

import space.traner.myfitness.R;

public class NotificationEngine {
    public static void notify(Context app) {

        String CHANNEL_ID = "notification_channel_01";
        CharSequence title = "Напоминание";
        String description = "Пора покормить кота";

        int NOTIFICATION_ID = 234;

        NotificationManager notificationManager = (NotificationManager) app.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, title, importance);
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(true);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(mChannel);
            }
        }
/*

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(app);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
*/

        NotificationCompat.Builder builder = new NotificationCompat.Builder(app, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(description)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(description))
                .setSmallIcon(R.drawable.checkbox_checked)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                .setAutoCancel(true);
                /*
                .setColor(getResources().getColor(R.color.background));
                .addAction(R.drawable.ic_launcher_foreground, "Call", resultPendingIntent)
                .addAction(R.drawable.ic_launcher_foreground, "More", resultPendingIntent)
                .addAction(R.drawable.ic_launcher_foreground, "And more", resultPendingIntent);
                */
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
