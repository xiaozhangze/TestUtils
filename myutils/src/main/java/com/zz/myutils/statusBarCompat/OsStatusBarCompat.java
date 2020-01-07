package com.zz.myutils.statusBarCompat;

import android.app.Activity;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 4:44.
 */
interface OsStatusBarCompat {
    void setDarkIconMode(@NonNull Activity activity, boolean darkIconMode);
    void setDarkIconMode(@NonNull Fragment fragment, boolean darkIconMode);
    void setDarkIconMode(@NonNull Window window, boolean darkIconMode);
}