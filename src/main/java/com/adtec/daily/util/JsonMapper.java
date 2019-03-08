package com.adtec.daily.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class JsonMapper {
    private ObjectMapper mapper;

    public JsonMapper() {
        this((JsonInclude.Include)null);
    }

    public JsonMapper(JsonInclude.Include include) {
        this.mapper = new ObjectMapper();
        if(include != null) {
            this.mapper.setSerializationInclusion(include);
        }

        this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static JsonMapper nonEmptyMapper() {
        return new JsonMapper(JsonInclude.Include.NON_EMPTY);
    }

    public static JsonMapper nonDefaultMapper() {
        return new JsonMapper(JsonInclude.Include.NON_DEFAULT);
    }

    public String toJson(Object object) {
        try {
            return this.mapper.writeValueAsString(object);
        } catch (IOException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public <T> T fromJson(String jsonString, Class<T> clazz) {
        try {
            if(jsonString != null && jsonString.length() > 0) {
                return this.mapper.readValue(jsonString, clazz);
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    public <T> T fromJson(String jsonString, JavaType javaType) {
        try {
            if(jsonString != null && jsonString.length() > 0) {
                return this.mapper.readValue(jsonString, javaType);
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    public JavaType contructCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
        return this.mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    public JavaType contructMapType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        return this.mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
    }

    public void update(String jsonString, Object object) {
        try {
            this.mapper.readerForUpdating(object).readValue(jsonString);
        } catch (JsonProcessingException var4) {
            var4.printStackTrace();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public String toJsonP(String functionName, Object object) {
        return this.toJson(new JSONPObject(functionName, object));
    }

    public void enableEnumUseToString() {
        this.mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        this.mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    }

    public ObjectMapper getMapper() {
        return this.mapper;
    }

    public boolean isJson(String str) {
        boolean result = true;
        JavaType javaType = this.contructMapType(Map.class, String.class, Object.class);
        Map val = (Map)this.fromJson(str, javaType);
        if(val == null) {
            result = false;
        }

        return result;
    }
}
