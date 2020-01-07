package com.zz.myutils.blurred;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 3:40.
 */
class Utils {

    static <T> T requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
        return obj;
    }

    static <T> T requireNonNull(T obj) {
        return requireNonNull(obj, "");
    }
}