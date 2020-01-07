package com.zz.myutils.blurred;

import android.graphics.Bitmap;
import android.view.View;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 3:39.
 */
public class DefaultSnapshotInterceptor implements Blurred.SnapshotInterceptor {
    @Override
    public Bitmap snapshot(View from, int backgroundColor, int foregroundColor, float scale, boolean antiAlias) {
        return BitmapProcessor.get().snapshot(from, backgroundColor, foregroundColor, scale, antiAlias);
    }
}