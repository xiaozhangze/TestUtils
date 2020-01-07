package com.zz.myutils.anyDialog;

import android.animation.Animator;
import android.view.View;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 4:25.
 */
public interface IAnim {
    /**
     * 进入动画
     *
     * @param target 背景
     * @return 动画时长
     */
    Animator inAnim(View target);

    /**
     * 消失动画
     *
     * @param target 背景
     * @return 动画时长
     */
    Animator outAnim(View target);
}
