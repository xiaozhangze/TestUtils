package com.zz.myutils.rxhttp.request.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zz.myutils.rxhttp.core.RxHttp;

/**
 * 判断网络的辅助类
 *
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 2:07.
 */
public class NetUtils {

    /**
     * 判断是否有网络
     */
    public static boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) RxHttp.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }
}
