package com.zz.myutils.rxhttp.core;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import com.zz.myutils.rxhttp.core.exception.RxHttpUninitializedException;
import com.zz.myutils.rxhttp.download.DownloadInfo;
import com.zz.myutils.rxhttp.download.RxDownload;
import com.zz.myutils.rxhttp.download.setting.DefaultDownloadSetting;
import com.zz.myutils.rxhttp.download.setting.DownloadSetting;
import com.zz.myutils.rxhttp.request.RxRequest;
import com.zz.myutils.rxhttp.request.base.BaseResponse;
import com.zz.myutils.rxhttp.request.exception.NullRequestSettingException;
import com.zz.myutils.rxhttp.request.setting.RequestSetting;

import io.reactivex.Observable;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:42.
 */

@SuppressLint("StaticFieldLeak")
public class RxHttp {

    private static RxHttp INSTANCE = null;

    private final Context mAppContext;
    private RequestSetting mRequestSetting = null;
    private DownloadSetting mDownloadSetting = null;

    private RxHttp(Context context) {
        mAppContext = context;
    }

    public static void init(@NonNull Context context) {
        INSTANCE = new RxHttp(context.getApplicationContext());
    }

    public static RxHttp getInstance() {
        if (INSTANCE == null) {
            throw new RxHttpUninitializedException();
        }
        return INSTANCE;
    }

    public static void initRequest(@NonNull RequestSetting setting) {
        getInstance().mRequestSetting = setting;
    }

    public static void initDownload(@NonNull DownloadSetting setting) {
        getInstance().mDownloadSetting = setting;
    }

    @NonNull
    public static Context getAppContext() {
        return getInstance().mAppContext;
    }

    @NonNull
    public static RequestSetting getRequestSetting() {
        RequestSetting setting = getInstance().mRequestSetting;
        if (setting == null) {
            throw new NullRequestSettingException();
        }
        return setting;
    }

    @NonNull
    public static DownloadSetting getDownloadSetting() {
        DownloadSetting setting = getInstance().mDownloadSetting;
        if (setting == null) {
            setting = new DefaultDownloadSetting();
        }
        return setting;
    }

    public static <T, R extends BaseResponse<T>> RxRequest<T, R> request(@NonNull Observable<R> observable) {
        return RxRequest.create(observable);
    }

    public static RxDownload download(@NonNull DownloadInfo info) {
        return RxDownload.create(info);
    }
}
