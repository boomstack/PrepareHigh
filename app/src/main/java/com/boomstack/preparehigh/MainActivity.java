package com.boomstack.preparehigh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.boomstack.preparehigh.activitycontroller.ACOneActivity;
import com.boomstack.preparehigh.broadcast.BCOneActivity;
import com.boomstack.preparehigh.multithread.MultiThreadActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToBroadcast(View view) {
        startActivity(new Intent(this, BCOneActivity.class));
    }

    public void onActivityControl(View view) {
        startActivity(new Intent(this, ACOneActivity.class));
    }

    public void onMultiThread(View view) {
        startActivity(new Intent(this, MultiThreadActivity.class));
    }
}
