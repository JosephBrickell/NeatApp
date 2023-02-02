package com.Neat.Factory;

import com.Neat.Factory.Transformer.BBCGoodFood;
import com.Neat.Factory.Transformer.DeliciousMagazine;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Factory {
    private static final Map<String, Class<? extends Website>> classMap = new HashMap<>();

    public static void registerClass(String name, Class<? extends Website> clazz) {
        classMap.put(name, clazz);
    }

    public static Website createInstance(String name) {
        Map<String, Class<? extends Website>> classMap2 = classMap;
        Class<? extends Website> clazz = classMap.get(name);
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @PostConstruct
    private void classes(){
        Factory.registerClass("bbcgoodfood", BBCGoodFood.class);
        Factory.registerClass("deliciousmagazine", DeliciousMagazine.class);
    }



}
