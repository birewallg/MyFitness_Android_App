package space.traner.myfitness.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcast extends BroadcastReceiver {

    public BootBroadcast() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, UpdateService.class));
    }
}