package com.zz.myutils.rxhttp.request;

/**
 * 子类继承，用于创建一个API接口实例
 * 新写一个无参静态方法调用{@link #api(Class)}去创建一个接口实例
 *
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 2:00.
 */
public class Api {

    public interface Header {
        /**
         * 添加以这个为名的Header可以让这个Request使用另一个BaseUrl
         */
        String BASE_URL_REDIRECT = "RxHttp-BaseUrl-Redirect";
        /**
         * 添加以这个为名的Header可以让这个Request支持缓存（有网联网获取，无网读取缓存）
         * 如//@Headers({Header.CACHE_ALIVE_SECOND + ":" + 10})
         */
        String CACHE_ALIVE_SECOND = "RxHttp-Cache-Alive-Second";
    }

    /**
     * 创建一个接口实例
     *
     * @param clazz Retrofit的ServiceInterface，建议定义为子类的内部接口
     * @param <T>   ServiceInterface的名字
     * @return 接口实例
     */
    protected static <T> T api(Class<T> clazz) {
        return RequestClientManager.getService(clazz);
    }

}
