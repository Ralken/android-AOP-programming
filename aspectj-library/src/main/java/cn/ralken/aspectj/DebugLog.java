package cn.ralken.aspectj;

import android.util.Log;

/**
 * Created by Ralken Liao on 07/12/2017.
 */

public class DebugLog {

    private DebugLog() {
    }

    public static void log(String tag, String message) {
        Log.d(tag, message);
    }
}
