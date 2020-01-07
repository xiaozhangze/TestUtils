package com.zz.myutils.rxhttp.download.exception;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:50.
 */
public class SaveFileDirMakeException extends RuntimeException {
    public SaveFileDirMakeException() {
        super("下载保存的文件父文件夹创建失败");
    }
}

