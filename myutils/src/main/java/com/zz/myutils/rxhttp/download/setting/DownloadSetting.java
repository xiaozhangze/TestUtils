package com.zz.myutils.rxhttp.download.setting;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zz.myutils.rxhttp.download.DownloadInfo;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:52.
 */
public interface DownloadSetting {

    @NonNull
    String getBaseUrl();

    /**
     * 获取默认超时时长，单位为毫秒数
     */
    @IntRange(from = 1)
    long getTimeout();

    /**
     * 获取Connect超时时长，单位为毫秒数
     * 返回0则去getTimeout
     */
    @IntRange(from = 0)
    long getConnectTimeout();

    /**
     * 获取Read超时时长，单位为毫秒数
     * 返回0则去getTimeout
     */
    @IntRange(from = 0)
    long getReadTimeout();

    /**
     * 获取Write超时时长，单位为毫秒数
     * 返回0则去getTimeout
     */
    @IntRange(from = 0)
    long getWriteTimeout();

    @Nullable
    String getSaveDirPath();

    @NonNull
    DownloadInfo.Mode getDefaultDownloadMode();
}
