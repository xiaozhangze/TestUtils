package com.zz.myutils;

import android.view.View;

import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 上午 11:42.
 */
public class ScrollCompat {

    public static boolean canScrollHorizontally(View v, int direction) {
        if (v instanceof ScrollingView) {
            return canScrollingViewScrollHorizontally((ScrollingView) v, direction);
        } else {
            return ViewCompat.canScrollHorizontally(v, direction);
        }
    }

    public static boolean canScrollVertically(View v, int direction) {
        if (v instanceof ScrollingView) {
            return canScrollingViewScrollVertically((ScrollingView) v, direction);
        } else {
            return ViewCompat.canScrollVertically(v, direction);
        }
    }

    private static boolean canScrollingViewScrollHorizontally(ScrollingView view, int direction) {
        final int offset = view.computeHorizontalScrollOffset();
        final int range = view.computeHorizontalScrollRange() - view.computeHorizontalScrollExtent();
        if (range == 0) return false;
        if (direction < 0) {
            return offset > 0;
        } else {
            return offset < range - 1;
        }
    }

    private static boolean canScrollingViewScrollVertically(ScrollingView view, int direction) {
        final int offset = view.computeVerticalScrollOffset();
        final int range = view.computeVerticalScrollRange() - view.computeVerticalScrollExtent();
        if (range == 0) return false;
        if (direction < 0) {
            return offset > 0;
        } else {
            return offset < range - 1;
        }
    }
}
