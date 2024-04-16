package com.sybven.jwt.token.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GsonUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(GsonUtils.class);

    public static String serializae(Object obj){
        Gson gson = new Gson();
        String jsonString = gson.toJson(obj);
        logger.info("GsonUtils serializae jsonString: " + jsonString);
        return jsonString;
    }
    
    public static <D>D toObject(String json, Class<D>dClass){
        Gson gson = new Gson();
        Type type = TypeToken.get(dClass).getType();
        D jsonObject = gson.fromJson(json, type);
        logger.info("GsonUtils toObject jsonObject: " + jsonObject.toString());
        return jsonObject;
    }
    
    public static <D>D toObject(Object obj, Class<D>dClass){
        Gson gson = new Gson();
        String jsonString = gson.toJson(obj);
        Type type = TypeToken.get(dClass).getType();
        try {
            D jsonObject = gson.fromJson(jsonString, type);
            logger.info("GsonUtils toObject jsonObject: " + jsonObject.toString());
            return jsonObject;
        } catch (Exception e) {
            logger.error("Error converting object to JSON", e);
            return null;
        }
    }
    
}
