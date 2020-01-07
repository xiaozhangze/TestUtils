package com.zz.myutils.actionBar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

import androidx.annotation.Nullable;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 4:41.
 */
class Utils {

    /**
     * 从当前上下文获取Activity
     */
    @Nullable
    static Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    static void finishActivity(Context context) {
        Activity activity = getActivity(context);
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }
}
