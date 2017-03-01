package com.boomstack.preparehigh.activitycontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.boomstack.preparehigh.R;

public class ACOneActivity extends ACBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acone);
        ActivityController.addToList(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeFromList();
    }

    public void gotoSecond(View view) {
        startActivity(new Intent(this, ACTwoActivity.class));
    }
}
