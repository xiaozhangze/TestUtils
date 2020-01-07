package com.zz.myutils.rxhttp.download.exception;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:49.
 */
public class SaveFileBrokenPointException extends RuntimeException {
    public SaveFileBrokenPointException() {
        super("文件已下载部分与断点续传不符");
    }
}

