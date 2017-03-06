package com.boomstack.preparehigh.multithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.boomstack.preparehigh.HolaPrint;
import com.boomstack.preparehigh.R;

public class MultiThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread);
    }

    public void onSelfAsyncTask(View view) {
        MyAsyncTask<String> task = new MyAsyncTask<String>() {
            @Override
            protected String doInBackground() {
                HolaPrint.pr("doInBackground");
                for (int i = 0; i < 10000; i++) {

                }
                HolaPrint.pr("doInBackground complete");
                return "complete";
            }

            @Override
            protected void onPreExecute() {
                HolaPrint.pr("pre execute");
            }

            @Override
            protected void onPostExecute(String s) {
                HolaPrint.pr("result: " + s);
            }
        };
        task.execute();
    }
}
