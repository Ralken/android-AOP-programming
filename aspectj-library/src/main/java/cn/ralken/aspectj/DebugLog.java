package cn.ralken.aspectj;

import android.util.Log;

/**
 * Created by Ralken Liao on 07/12/2017.
 */

public class DebugLog {
    private static final String LOG_TAG = "aspectj-log";

    private DebugLog() {
    }

    public static void log(String message) {
        Log.d(LOG_TAG, message);
    }
}
