package com.zz.myutils.rxhttp.download;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 1:55.
 */
public interface DownloadApi{
    @Streaming
    @GET
    Observable<ResponseBody> download(@Header("RANGE") String range, @Url String url);
}
