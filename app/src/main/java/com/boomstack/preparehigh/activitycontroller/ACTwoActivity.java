package com.boomstack.preparehigh.activitycontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.boomstack.preparehigh.R;

public class ACTwoActivity extends ACBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actwo);
        ActivityController.addToList(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeFromList();
    }

    public void gotoThird(View view) {
        startActivity(new Intent(this, ACThreeActivity.class));
    }
}
