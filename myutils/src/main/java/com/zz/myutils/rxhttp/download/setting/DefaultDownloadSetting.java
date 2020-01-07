package com.zz.myutils.rxhttp.download.setting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zz.myutils.rxhttp.download.DownloadInfo;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:52.
 */
public class DefaultDownloadSetting implements DownloadSetting {

    @NonNull
    @Override
    public String getBaseUrl() {
        return "http://api.rxhttp.download/";
    }

    @Override
    public long getTimeout() {
        return 60000;
    }

    @Override
    public long getConnectTimeout() {
        return 0;
    }

    @Override
    public long getReadTimeout() {
        return 0;
    }

    @Override
    public long getWriteTimeout() {
        return 0;
    }

    @Nullable
    @Override
    public String getSaveDirPath() {
        return null;
    }

    @NonNull
    @Override
    public DownloadInfo.Mode getDefaultDownloadMode() {
        return DownloadInfo.Mode.APPEND;
    }
}
