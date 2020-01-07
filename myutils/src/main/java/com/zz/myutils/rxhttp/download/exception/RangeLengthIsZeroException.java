package com.zz.myutils.rxhttp.download.exception;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:49.
 */
public class RangeLengthIsZeroException extends RuntimeException {
    public RangeLengthIsZeroException() {
        super("断点处请求长度为0");
    }
}
