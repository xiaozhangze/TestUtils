package com.zz.myutils.rxhttp.request.interceptor;

import androidx.annotation.NonNull;

import com.zz.myutils.rxhttp.request.Api;
import com.zz.myutils.rxhttp.request.utils.NetUtils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 缓存过滤器
 * 用于为Response配置缓存策略
 *
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 2:10.
 */
public class CacheControlNetworkInterceptor extends BaseCacheControlInterceptor {

    public static void addTo(@NonNull OkHttpClient.Builder builder) {
        builder.addNetworkInterceptor(new CacheControlNetworkInterceptor());
    }

    private CacheControlNetworkInterceptor() {
    }

    @NonNull
    @Override
    protected Request getCacheRequest(Request request, int age) {
        return request.newBuilder()
                .removeHeader(Api.Header.CACHE_ALIVE_SECOND)
                .build();
    }

    @NonNull
    @Override
    protected Response getCacheResponse(Response response, int age) {
        if (NetUtils.isConnected()) {
            if (age <= 0) {
                return response.newBuilder()
                        .removeHeader("Cache-Control")
                        .build();
            } else {
                return response.newBuilder()
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + age)
                        .build();
            }
        } else {
            return response.newBuilder()
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + Integer.MAX_VALUE)
                    .build();
        }
    }
}