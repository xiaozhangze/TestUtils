package com.zz.myutils.rxhttp.core.utils;

import android.os.Environment;

import com.zz.myutils.rxhttp.core.RxHttp;

import java.io.File;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:47.
 */
public class SDCardUtils {

    public static String getCacheDir() {
        File cacheFile = null;
        if (isSDCardAlive()) {
            cacheFile = RxHttp.getAppContext().getExternalCacheDir();
        }
        if (cacheFile == null) {
            cacheFile = RxHttp.getAppContext().getCacheDir();
        }
        return cacheFile.getAbsolutePath();
    }

    public static String getDownloadCacheDir() {
        File dir = null;
        if (isSDCardAlive()) {
            dir = RxHttp.getAppContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        }
        if (dir == null) {
            dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return dir.getAbsolutePath();
    }

    private static boolean isSDCardAlive() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}