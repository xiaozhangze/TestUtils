package com.zz.myutils.rxhttp.core.manager;

import retrofit2.Retrofit;

/**
 * 用于管理Retrofit实例
 * 子类继承后自行判断是否采用单例模式
 *
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:44.
 */
public abstract class BaseClientManager {
    protected abstract Retrofit create();
}
