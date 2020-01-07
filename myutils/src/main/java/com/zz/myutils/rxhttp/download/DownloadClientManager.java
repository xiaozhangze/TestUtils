package com.zz.myutils.rxhttp.download;

import com.zz.myutils.rxhttp.core.RxHttp;
import com.zz.myutils.rxhttp.core.manager.BaseClientManager;
import com.zz.myutils.rxhttp.core.utils.BaseUrlUtils;
import com.zz.myutils.rxhttp.download.interceptor.RealNameInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 1:56.
 */
class DownloadClientManager extends BaseClientManager {

    private static DownloadClientManager INSTANCE = null;
    private final Retrofit mRetrofit;

    private DownloadClientManager() {
        mRetrofit = create();
    }

    /**
     * 采用单例模式
     *
     * @return RequestClientManager
     */
    private static DownloadClientManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DownloadClientManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DownloadClientManager();
                }
            }
        }
        return INSTANCE;
    }

    static DownloadApi getService() {
        return getInstance().mRetrofit.create(DownloadApi.class);
    }

    @Override
    protected Retrofit create() {
        return new Retrofit.Builder()
                .client(createOkHttpClient())
                .baseUrl(BaseUrlUtils.checkBaseUrl(RxHttp.getDownloadSetting().getBaseUrl()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient createOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long timeout = RxHttp.getDownloadSetting().getTimeout();
        long connectTimeout = RxHttp.getDownloadSetting().getConnectTimeout();
        long readTimeout = RxHttp.getDownloadSetting().getReadTimeout();
        long writeTimeout = RxHttp.getDownloadSetting().getWriteTimeout();
        builder.connectTimeout(connectTimeout > 0 ? connectTimeout : timeout, TimeUnit.MILLISECONDS);
        builder.readTimeout(readTimeout > 0 ? readTimeout : timeout, TimeUnit.MILLISECONDS);
        builder.writeTimeout(writeTimeout > 0 ? writeTimeout : timeout, TimeUnit.MILLISECONDS);
        RealNameInterceptor.addTo(builder);
        return builder.build();
    }
}
