package com.zz.myutils.swipe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 上午 11:44.
 */
public class SwipeBackActivity extends AppCompatActivity {

    protected SwipeBackHelper mSwipeBackHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwipeBackHelper = SwipeBackHelper.inject(this);
        mSwipeBackHelper.setSwipeBackEnable(swipeBackEnable());
        mSwipeBackHelper.setSwipeBackOnlyEdge(swipeBackOnlyEdge());
        mSwipeBackHelper.setSwipeBackForceEdge(swipeBackForceEdge());
        mSwipeBackHelper.setSwipeBackDirection(swipeBackDirection());
        mSwipeBackHelper.getSwipeBackLayout().setShadowStartColor(0);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeBackHelper.onPostCreate();
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        mSwipeBackHelper.onEnterAnimationComplete();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSwipeBackHelper.onDestroy();
    }

    @Override
    public void finish() {
        if (mSwipeBackHelper.finish()) {
            super.finish();
        }
    }

    protected boolean swipeBackEnable() {
        return true;
    }

    protected boolean swipeBackOnlyEdge() {
        return false;
    }

    protected boolean swipeBackForceEdge() {
        return true;
    }

    @SwipeBackDirection
    protected int swipeBackDirection() {
        return SwipeBackDirection.FROM_LEFT;
    }
}
