package com.zz.myutils.rxhttp.request.exception;

/**
 * 服务器请求成功，返回失败码时抛出，方便统一处理
 *
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 1:59.
 */
public class ApiException extends Exception {

    private final int code;
    private final String msg;

    public ApiException(int code, String msg) {
        super(msg + "(code=" + code + ")");
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}