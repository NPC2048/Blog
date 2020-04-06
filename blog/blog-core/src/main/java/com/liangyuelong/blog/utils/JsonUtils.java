package com.liangyuelong.blog.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.liangyuelong.blog.common.constant.DateFormatConstants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author yuelong.liang
 */
public class JsonUtils {

    private static int maxSize = 16;

    private static final ConcurrentMap<String, ObjectMapper> CACHE = new ConcurrentHashMap<>(maxSize);

    private static final ObjectMapper DEFAULT_OM = customObjectMapper(DateFormatConstants.DEFAULT);

    public static <T> T parse(String json, Class<T> tClass) {
        return parse(DEFAULT_OM, json, tClass);
    }

    public static String toJson(Object value) {
        return toJson(DEFAULT_OM, value);
    }

    public static <T> T parse(String json, Class<T> tClass, String pattern) {
        return parse(getObjectMapper(pattern), json, tClass);
    }

    public static String toJson(Object value, String pattern) {
        return toJson(getObjectMapper(pattern), value);
    }

    private static <T> T parse(ObjectMapper om, String json, Class<T> tClass) {
        try {
            return om.readValue(json, tClass);
        } catch (IOException ignored) {
        }
        return null;
    }

    private static String toJson(ObjectMapper om, Object value) {
        try {
            return om.writeValueAsString(value);
        } catch (JsonProcessingException ignored) {
            return null;
        }
    }

    public static ObjectMapper buildObjectMapper(String pattern) {
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat(pattern));
        return om;
    }

    private static ObjectMapper customObjectMapper(String pattern) {
        ObjectMapper om = buildObjectMapper(pattern);
        om.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        om.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return om;
    }

    /**
     * 获取 ObjectMapper
     * 先根据 pattern 从 CACHE 获取，如果没有，则根据 pattern 生成 ObjectMapper,
     * 存入 CACHE 后返回
     *
     * @param pattern 日期格式化
     * @return ObjectMapper
     */
    private static ObjectMapper getObjectMapper(String pattern) {
        ObjectMapper om = CACHE.get(pattern);
        if (om == null) {
            om = customObjectMapper(pattern);
            if (CACHE.size() >= maxSize) {
                CACHE.clear();
            }
            CACHE.put(pattern, om);
        }
        return om;
    }
}
