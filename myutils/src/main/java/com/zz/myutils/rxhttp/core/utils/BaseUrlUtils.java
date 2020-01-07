package com.zz.myutils.rxhttp.core.utils;

/**
 * 检查BaseUrl是否以"/"结尾
 *
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:47.
 */
public class BaseUrlUtils {

    public static String checkBaseUrl(String url) {
        if (url.endsWith("/")) {
            return url;
        } else {
            return url + "/";
        }
    }
}
