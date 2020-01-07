package com.zz.myutils.rxhttp.core.exception;

/**
 * 在调用网络请求之前应该先进行初始化，建议在Application中初始化
 *
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:44.
 */
public class RxHttpUninitializedException extends RuntimeException {
    public RxHttpUninitializedException() {
        super("RxHttp未初始化");
    }
}