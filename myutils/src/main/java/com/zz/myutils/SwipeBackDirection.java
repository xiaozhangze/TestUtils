package com.zz.myutils;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 上午 11:46.
 */
@IntDef({SwipeBackDirection.FROM_LEFT,
        SwipeBackDirection.FROM_TOP,
        SwipeBackDirection.FROM_RIGHT,
        SwipeBackDirection.FROM_BOTTOM})
@Retention(RetentionPolicy.SOURCE)
public @interface SwipeBackDirection {
    int FROM_LEFT = 1;
    int FROM_RIGHT = 1 << 1;
    int FROM_TOP = 1 << 2;
    int FROM_BOTTOM = 1 << 3;
}
