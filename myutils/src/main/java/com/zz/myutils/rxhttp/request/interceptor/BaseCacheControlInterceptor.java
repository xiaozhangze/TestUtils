package com.zz.myutils.rxhttp.request.interceptor;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.zz.myutils.rxhttp.request.Api;
import com.zz.myutils.rxhttp.request.utils.NonNullUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 缓存过滤器
 * 在基类过滤掉非GET请求和未配置{@link Api.Header#CACHE_ALIVE_SECOND}的请求
 *
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 2:10.
 */
public class BaseCacheControlInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!TextUtils.equals(request.method(), "GET")) {
            return chain.proceed(request);
        }
        List<String> headers = request.headers(Api.Header.CACHE_ALIVE_SECOND);
        if (!NonNullUtils.check(headers)) {
            return chain.proceed(request);
        }
        int age = getCacheControlAge(headers.get(0));
        Request requestCached = getCacheRequest(request, age);
        Response response = chain.proceed(requestCached);
        return getCacheResponse(response, age);
    }

    @NonNull
    protected Request getCacheRequest(Request request, int age) {
        return request;
    }

    @NonNull
    protected Response getCacheResponse(Response response, int age) {
        return response;
    }

    private int getCacheControlAge(String age) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException ignore) {
            return 0;
        }
    }
}