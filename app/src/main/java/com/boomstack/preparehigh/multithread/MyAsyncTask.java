package com.boomstack.preparehigh.multithread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/**
 * Created by wangkangfei on 17/3/6.
 */

public abstract class MyAsyncTask<Result> {
    private HandlerThread ht;
    private Handler uiHandler;
    private Handler workHandler;

    public MyAsyncTask() {
        ht = new HandlerThread("working thread");
        ht.start();
        //working thread handler
        workHandler = new Handler(ht.getLooper());
        //ui handler
        uiHandler = new Handler(Looper.getMainLooper());
    }

    protected void onPreExecute() {

    }

    protected abstract Result doInBackground();

    protected void onPostExecute(Result result) {

    }

    public void execute() {
        onPreExecute();
        workHandler.post(new Runnable() {
            @Override
            public void run() {
                Result result = doInBackground();
                postResult(result);
            }
        });
    }

    private void postResult(final Result result) {
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                onPostExecute(result);
            }
        });
    }


}
