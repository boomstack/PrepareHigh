package com.boomstack.preparehigh.activitycontroller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.boomstack.preparehigh.R;

public class ACBaseActivity extends AppCompatActivity {
    ActivityCycleReceiver receiver;
    public static final String BROADCAST_FINISH_ALL = "broadcast_finish_all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acbase);
        registerReceiver();
    }

    private void registerReceiver() {
        receiver = new ActivityCycleReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(BROADCAST_FINISH_ALL);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }

    protected void finishCurrentActivity() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    class ActivityCycleReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (BROADCAST_FINISH_ALL.equals(intent.getAction())) {
                finishCurrentActivity();
            }
        }
    }
}
