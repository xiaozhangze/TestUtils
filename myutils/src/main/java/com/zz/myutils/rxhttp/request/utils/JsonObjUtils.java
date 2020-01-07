package com.zz.myutils.rxhttp.request.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @version v1.0.1
 * @auther zz
 * @date 2020/1/7 0007 下午 2:08.
 */
public class JsonObjUtils {

    private final JSONObject mJsonObject;

    private JsonObjUtils() {
        mJsonObject = new JSONObject();
    }

    public static JsonObjUtils create() {
        return new JsonObjUtils();
    }

    public JsonObjUtils add(String key, int value) {
        try {
            mJsonObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JsonObjUtils add(String key, float value) {
        try {
            mJsonObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JsonObjUtils add(String key, double value) {
        try {
            mJsonObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JsonObjUtils add(String key, boolean value) {
        try {
            mJsonObject.put(key, value ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JsonObjUtils add(String key, String value) {
        try {
            mJsonObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JSONObject get() {
        return mJsonObject;
    }

    public String toJson() {
        return mJsonObject.toString();
    }
}
