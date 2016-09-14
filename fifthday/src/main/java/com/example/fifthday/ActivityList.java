package com.example.fifthday;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aslan on 2016/9/14.
 */
public class ActivityList {
    public static List<Activity> mActivityList=new ArrayList<>();
    public static void finishAll(){
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
    public static void addActivity(Activity activity){
        mActivityList.add(activity);
    }
}
