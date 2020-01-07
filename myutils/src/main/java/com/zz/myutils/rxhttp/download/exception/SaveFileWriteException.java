package com.zz.myutils.rxhttp.download.exception;

/**
 * @version v1.0.0
 * @auther zz
 * @date 2020/1/7 0007 下午 1:50.
 */
public class SaveFileWriteException extends RuntimeException {
    public SaveFileWriteException() {
        super("下载保存的文件写入失败");
    }
}

