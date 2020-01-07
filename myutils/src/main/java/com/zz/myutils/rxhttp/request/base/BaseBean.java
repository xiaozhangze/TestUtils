package com.zz.myutils.rxhttp.request.base;

import com.google.gson.Gson;
import com.zz.myutils.rxhttp.request.utils.JsonFormatUtils;

import java.io.Serializable;

/**
 * 网络请求的实体基类
 *
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 1:58.
 */
public class BaseBean implements Serializable {

    public String toJson() {
        return new Gson().toJson(this);
    }

    public String toFormatJson() {
        return JsonFormatUtils.format(toJson());
    }
}
