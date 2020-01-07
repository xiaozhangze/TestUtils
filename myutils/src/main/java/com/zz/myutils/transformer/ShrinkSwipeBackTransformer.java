package com.zz.myutils.transformer;

import android.view.View;

import androidx.annotation.FloatRange;

import com.zz.myutils.SwipeBackLayout;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 上午 11:44.
 */
public class ShrinkSwipeBackTransformer implements SwipeBackLayout.SwipeBackTransformer {

    private final float mScale;
    private final float mAlpha;

    public ShrinkSwipeBackTransformer() {
        this(0.96F, 1F);
    }

    public ShrinkSwipeBackTransformer(@FloatRange(from = 0, to = 1) float scale,
                                      @FloatRange(from = 0, to = 1) float alpha) {
        mScale = scale;
        mAlpha = alpha;
    }

    @Override
    public void transform(View currentView, View previousView, float fraction, int swipeDirection) {
        if (previousView == null) {
            return;
        }
        float scale = mScale + (1 - mScale) * fraction;
        previousView.setScaleX(scale);
        previousView.setScaleY(scale);
        float alpha = mAlpha + (1 - mAlpha) * fraction;
        previousView.setAlpha(alpha);
    }
}
