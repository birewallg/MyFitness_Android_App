package space.traner.myfitness.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;

import androidx.annotation.Nullable;

import space.traner.myfitness.util.NotificationEngine;

public class UpdateService extends Service {
    private Looper serviceLooper;
    private ServiceHandler serviceHandler;

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            // Normally we would do some work here, like download a file.
            // For our sample, we just sleep for 5 seconds.
            NotificationEngine.notify(getBaseContext());
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //stopSelf(msg.arg1);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Служба создана", Toast.LENGTH_SHORT).show();
        HandlerThread thread = new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        serviceLooper = thread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if ((flags & START_FLAG_RETRY) == 0) {
            // TODO Если это повторный запуск, выполнить какие-то действия.
            Toast.makeText(this, "Если это повторный запуск", Toast.LENGTH_SHORT).show();
        } else {
            // TODO Альтернативные действия в фоновом режиме.
            Toast.makeText(this, "Альтернативные действия", Toast.LENGTH_SHORT).show();

        }
        Message msg = serviceHandler.obtainMessage();
        msg.arg1 = startId;
        serviceHandler.sendMessage(msg);
        /*String CHANNEL_ID = "Cat channel";
        int NOTIFICATION_ID = 888;
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);*/

        //NotificationEngine.notify(getBaseContext());

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Служба остановлена",
                Toast.LENGTH_SHORT).show();
    }
}