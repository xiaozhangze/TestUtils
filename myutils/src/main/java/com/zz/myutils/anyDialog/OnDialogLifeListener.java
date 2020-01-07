package com.zz.myutils.anyDialog;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 4:28.
 */
public interface OnDialogLifeListener {
    void onCreated(AnyDialog anyDialog);
    void onEnter(AnyDialog anyDialog);
    void onShown(AnyDialog anyDialog);
    void onExit(AnyDialog anyDialog);
    void onDismissed(AnyDialog anyDialog);
}