package com.boomstack.preparehigh.activitycontroller;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.boomstack.preparehigh.R;

public class ACThreeActivity extends ACBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acthree);
        ActivityController.addToList(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeFromList();
    }

    public void onFinishAll(View view) {
        ActivityController.removeAll();
    }

    public void onFinishAllBroadcast(View view) {
        Intent i = new Intent(ACBaseActivity.BROADCAST_FINISH_ALL);
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);
    }
}
