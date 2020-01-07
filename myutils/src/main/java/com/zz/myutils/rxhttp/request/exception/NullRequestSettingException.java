package com.zz.myutils.rxhttp.request.exception;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 2:00.
 */
public class NullRequestSettingException extends RuntimeException {
    public NullRequestSettingException() {
        super("RequestSetting未设置");
    }
}

