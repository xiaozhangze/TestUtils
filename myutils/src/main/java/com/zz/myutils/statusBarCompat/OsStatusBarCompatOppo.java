package com.zz.myutils.statusBarCompat;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 4:46.
 */
class OsStatusBarCompatOppo implements OsStatusBarCompat {

    @Override
    public void setDarkIconMode(@NonNull Activity activity, boolean darkIconMode) {
        setDarkIconMode(activity.getWindow(), darkIconMode);
    }

    @Override
    public void setDarkIconMode(@NonNull Fragment fragment, boolean darkIconMode) {
        if (fragment.getActivity() != null) {
            setDarkIconMode(fragment.getActivity(), darkIconMode);
        }
    }

    @Override
    public void setDarkIconMode(@NonNull Window window, boolean darkIconMode) {
        OppoStatusBarUtils.setDarkIconMode(window, darkIconMode);
    }

    private static class OppoStatusBarUtils {

        private static final int SYSTEM_UI_FLAG_OP_STATUS_BAR_TINT = 0x00000010;

        private static void setDarkIconMode(Window window, boolean darkMode) {
            int vis = window.getDecorView().getSystemUiVisibility();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (darkMode) {
                    vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                } else {
                    vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (darkMode) {
                    vis |= SYSTEM_UI_FLAG_OP_STATUS_BAR_TINT;
                } else {
                    vis &= ~SYSTEM_UI_FLAG_OP_STATUS_BAR_TINT;
                }
            }
            window.getDecorView().setSystemUiVisibility(vis);
        }
    }

}
