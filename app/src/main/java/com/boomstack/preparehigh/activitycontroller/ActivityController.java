package com.boomstack.preparehigh.activitycontroller;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkangfei on 17/3/1.
 */

public class ActivityController {
    public static List<Activity> activityList = new ArrayList<>();

    public static void addToList(Activity activity) {
        activityList.add(activity);
    }

    public static void removeFromList() {
        if (activityList.size() < 1) {
            return;
        }
        activityList.remove(activityList.size() - 1);
    }

    public static void removeAll() {
        for (Activity a : activityList) {
            if (a != null) {
                a.finish();
            }
        }
    }
}
