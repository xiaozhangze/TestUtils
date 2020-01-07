package com.zz.myutils.rxhttp.request.base;

/**
 * 网络接口返回json格式对应的实体类
 *
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 1:59.
 */
public interface BaseResponse<E> {

    int getCode();

    void setCode(int code);

    E getData();

    void setData(E data);

    String getMsg();

    void setMsg(String msg);
}