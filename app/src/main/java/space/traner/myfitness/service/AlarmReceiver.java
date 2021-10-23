package space.traner.myfitness.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    private String TAG = "AlarmReceiverBroadcastReceiver";

    public AlarmReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "AlarmService", Toast.LENGTH_LONG).show();

        Log.e(TAG, "AlarmReceiver.onReceive");
    }
}
