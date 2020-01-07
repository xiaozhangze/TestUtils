package com.zz.myutils.rxhttp.download.utils;


import androidx.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:53.
 */
public class RxNotify {

    public static void runOnUiThread(@NonNull final Action action) {
        Observable.empty()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        action.run();
                    }
                });
    }

    public interface Action {
        void run();
    }
}
